package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")// 싱글테이블에서 구분하는 컬럼
public abstract  class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;


    private int price;
    private String name;
    private int stockQuantity;



}