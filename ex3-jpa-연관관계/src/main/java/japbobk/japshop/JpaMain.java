package japbobk.japshop;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    static EntityManager em = emf.createEntityManager();

    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {


        tx.begin();
        try {

            insert();

            em.flush();
            em.clear();
            //////// find를 같이할경우 항상 flush후에 진행!
            Member findMember = em.find(Member.class, 1L);
            List<Order> orderList = findMember.getOrderList();




            System.out.println("+++++++++++++++++++++++++");
            System.out.println("order =" + orderList);
            System.out.println("+++++++++++++++++++++++++");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void insert() {
        //멤버 생성
        for (int i = 0; i < 5; i++) {
            Member member = new Member();
            member.setName("test" + i);

            em.persist(member);// context에 저장되는 관계모든 객체는 persist되어야 한다.
            //주문생성
            System.out.println("+================+");
            for (int j = 0; j < 2; j++) {
                Order order = new Order();
                order.setMember(member);// member객체를 context에 저장한지 않은채로

                order.setStatus(OrderStatus.ORDER);
                // order를 저장할수 없다
                em.persist(order);
            }
        }
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setName("item"+i);
            em.persist(item);
        }


    }
}
