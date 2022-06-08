package japbobk.japshop.main;

import jpabook.jpashop.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();


        tx.begin();
        try {


            User member = new User();
            member.setName("member");
            em.persist(member);

            User member1 = new User();
            member1.setName("member1");
            em.persist(member1);

            User member2 = new User();
            member2.setName("member2");
            em.persist(member2);

            User member3 = new User();
            member3.setName("member3");
            em.persist(member3);

            User member4 = new User();
            member4.setName("member4");
            em.persist(member4);


            User member5 = new User();
            member5.setName("member5");
            em.persist(member5);

            User member6 = new User();
            member6.setName("member6");
            em.persist(member6);


            member6.getUserFollowing().getFollowingList().add(member);
            member6.getFollowingList().add(member);
            member.getUserFollower().getFollowerList().add(member6);
            member.getFollowerList().add(member6);

            member6.getUserFollowing().getFollowingList().add(member2);
            member6.getFollowingList().add(member2);
            member2.getUserFollower().getFollowerList().add(member6);
            member2.getFollowerList().add(member6);


            member6.getUserFollowing().getFollowingList().add(member1);
            member6.getFollowingList().add(member1);
            member1.getUserFollower().getFollowerList().add(member6);
            member1.getFollowerList().add(member6);

            member6.getUserFollowing().getFollowingList().add(member4);
            member6.getFollowingList().add(member4);
            member4.getUserFollower().getFollowerList().add(member6);
            member4.getFollowerList().add(member6);


            member.getUserFollowing().getFollowingList().add(member6);
            member.getFollowingList().add(member6);
            member6.getUserFollower().getFollowerList().add(member6);
            member6.getFollowerList().add(member6);




//
//
//
//
//
//            Friend friend = new Friend();
//            friend.setUser(member);
//            friend.setFriend(member1);
//
////
//            em.flush();
//            em.clear();
////

            User findMember = em.find(User.class , 7L);
            List<User> memberList = findMember.getFollowerList();




            System.out.println("+++++++++++++++++++++++++");
            for(int i =0 ; i< memberList.size();  i++){
                System.out.println("name : " + memberList.get(i).getName());
            }
            System.out.println("+++++++++++++++++++++++++");
//
//
//            Member findMember2 = em.find(Member.class , 2L);
//            List<Member> memberList2 = findMember2.getFriends();

//            System.out.println("+++++++++++++++++++++++++");
//            System.out.println("order222222222 =" + memberList2);
//            System.out.println("+++++++++++++++++++++++++");


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }


}
