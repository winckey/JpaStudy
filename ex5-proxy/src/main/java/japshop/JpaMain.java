package japshop;

import domain.Member;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    static EntityManager em = emf.createEntityManager();

    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {


        tx.begin();
        try {
            Team team = new Team();
            team.setName("team");

            em.persist(team);
            Member member1 = new  Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            member1.getTeam().getMembers().add(member1);
            em.persist(member1);


            Member member2 = new  Member();
            member2.setUsername("member2");
            member2.setTeam(team);
            member2.getTeam().getMembers().add(member2);
            em.persist(member2);


            Team team1 =em.find(Team.class , 1L);

            System.out.println("+++++++++++++++++++++++++");
            System.out.println("order =" + team.getMembers());
            System.out.println("+++++++++++++++++++++++++");



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
