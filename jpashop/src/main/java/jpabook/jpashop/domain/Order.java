package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    //연관관계주인은 fk가 가까운쪽으로


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems  = new ArrayList<>();



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;



    private LocalDateTime orderDateTime;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
