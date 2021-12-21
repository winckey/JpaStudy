package jpabook.jpashop.service;

import jpabook.jpashop.Member;
import jpabook.jpashop.MemberRepository;
import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional// 트렌잭션 생성 어노테이션
//   EntityTransaction tx = em.getTransaction();
//        tx.begin();
// 트랜젝션 어노테이션은 test와 함께쓰이면 롤백함수를 호출 해버린다
// [           main] o.s.t.c.transaction.TransactionContext   : Rolled back transaction for test
public class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;


    @Test//test는 함수별로 다해보기

    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());

    }


}