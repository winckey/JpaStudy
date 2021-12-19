package japbobk.japshop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

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
            member.setName("장현진");
            member.setCreateDate(LocalDateTime.now());
            member.setCreateBy("admin");

            em.persist(member);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
