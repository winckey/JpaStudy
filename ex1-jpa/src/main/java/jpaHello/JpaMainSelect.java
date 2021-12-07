package jpaHello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainSelect {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 팩토리는 딱 하나만 하나만 만들어야 한다. 어플리케이션 로딩시점에

        EntityManager entityManager = emf.createEntityManager();
        // 트렌잭션 단위로 manager를 사용한다.
        EntityTransaction et = entityManager.getTransaction();
        // jpa 는 반듯이 트렌잭션 단위로 움직여야함
        et.begin();

        //정석코드 이거를 꼭 따르자 (스프링에서는 알아서 다해줌)
        try {
            Member findMember = entityManager.find(Member.class , 1L);
            System.out.println("id = " +findMember.getId());

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            entityManager.close();
        }
        /////////////

        emf.close();
    }
}
