package japHello4;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 팩토리는 딱 하나만 하나만 만들어야 한다. 어플리케이션 로딩시점에


        EntityManager em = emf.createEntityManager();
        // 트렌잭션 단위로 manager를 사용한다.
        // 고객의 요청이 올때 마다 생성된다 -> 스레드로 공유? 절대 안된다.(db커넥션 쓰듯이)
        EntityTransaction et = em.getTransaction();
        // jpa 는 반듯이 트렌잭션 단위로 움직여야함
        et.begin();

        //정석코드 이거를 꼭 따르자 (스프링에서는 알아서 다해줌)
        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//            //회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            //연관관계가 없음
//            Team findTeam = em.find(Team.class, team.getId());


            // 단방향
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
            em.persist(member);

//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            //참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//            System.out.println("finde = " + findTeam.getId());

            Member findMember = em.find(Member.class, member.getId());
            List<Member> memberList = findMember.getTeam().getMembers();
            for (Member m : memberList) {
                System.out.println("m  =  "+ m.getName());
            }

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        /////////////

        emf.close();
    }
}
