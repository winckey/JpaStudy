package jpabook.jpashop.domain;


import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;
    private int orderPrice;
    private int count;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

}
