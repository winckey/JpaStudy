package jpaHello3.jpaHello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaPersistence {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 팩토리는 딱 하나만 하나만 만들어야 한다. 어플리케이션 로딩시점에


        EntityManager entityManager = emf.createEntityManager();
        // 트렌잭션 단위로 manager를 사용한다.
        // 고객의 요청이 올때 마다 생성된다 -> 스레드로 공유? 절대 안된다.(db커넥션 쓰듯이)
        EntityTransaction et = entityManager.getTransaction();
        // jpa 는 반듯이 트렌잭션 단위로 움직여야함
        et.begin();

        //정석코드 이거를 꼭 따르자 (스프링에서는 알아서 다해줌)
        try {
            //비영속



            et.commit();// 쿼리는 커밋하면서 날라간다.
        } catch (Exception e) {
            et.rollback();
        } finally {
            entityManager.close();
        }
        /////////////

        emf.close();
    }
}
