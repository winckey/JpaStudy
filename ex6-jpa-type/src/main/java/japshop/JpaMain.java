package japshop;

import domain.Member;
import domain.Period;

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
//            Movie movie = new Movie();
//            movie.setDirector("a");
//            movie.setActor("bb");
//            movie.setName("스파이터맨");
//            movie.setPrice(12000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();

            Member member = new Member();
            member.setPeriod(new Period(LocalDateTime.now()));
            member.setName("장현진2");
            member.setCreateDate(LocalDateTime.now());
            member.setCreateBy("admin");

            member.getFavaoriteFoods().add("1");
            member.getFavaoriteFoods().add("2");
            member.getFavaoriteFoods().add("3");
            member.getFavaoriteFoods().add("4");
  member.getFavaoriteFoods().add("1");
            member.getFavaoriteFoods().add("2");
            member.getFavaoriteFoods().add("3");
            member.getFavaoriteFoods().add("4");
            em.persist(member);


            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class , member.getId());
            em.detach(refMember);
            System.out.println("ref = "+member.getName());





            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
