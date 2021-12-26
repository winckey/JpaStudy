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
            Team team2 = new Team();
            team2.setName("TeamB");
            em.persist(team2);
            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
            em.persist(member);
            em.flush();
            em.clear();
            System.out.println("저장=================================");

//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            //참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//            System.out.println("finde = " + findTeam.getId());

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = em.find(Team.class , findMember.getTeam().getId());
            findMember.getTeam().setName("chageTeam");
            findTeam.setName("rollbackTeam");
            System.out.println("!!!!!!!!!!!!!name = "+findTeam.getName());
            //https://ecsimsw.tistory.com/entry/JPA-%EC%96%91%EB%B0%A9%ED%96%A5-%EB%A7%A4%ED%95%91-MappedBy 양방향 멥핑 참고
//            // teamA.getMembers().add(memberA)과 memberA.setTeam(teamB)가 호출된다면 어떻게 처리할 것인가.
//            가장 중요한 점은, FK는 연관관계의 주인만 관리할 수 있다. "관리" 란, FK를 등록하거나 수정하고 DB에 접속하여 그 값을 바꿀 수 있다는 것을 의미한다.
//            즉 연관관계의 주인이 아닌 객체에서 아무리 등록 혹은 수정 작업을 해도 DB에는 전혀 반영이 되지 않고, 오직 읽기만 가능하다.

            // 여기서 말하는 작업은 fk와 관련된 작업!!! ex  team.getMembers().add(member);이거 안댐 db에 member.team_id가 null로 됨 
            //                                        member.setTeam(team); 이거는 db에 잘들어감

            System.out.println("================" +findMember.getTeam().getId() );








            ////////////////
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
