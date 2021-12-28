package jpabook.jpashop;


import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.*;


@Repository//dao와 비슷한것
public class MemberRepositorytest {



    @PersistenceContext// 엔티티메니저를 알아서 주입을 해준다!(팩토리 매니저 과정 생략)
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//    EntityManager em = emf.createEntityManager();
//    EntityTransaction tx = em.getTransaction();
    private EntityManager em;


    public Long save(Member member){//저장

        em.persist(member);
        return member.getId();//커맨드와 쿼리는 분리해라 (원칙)!

    }


    public Member find(Long id){//조회

        return   em.find(Member.class , id);

    }
}
