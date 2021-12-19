package jpabook.jpashop.domain;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")// 내가 조인해오는것이 무엇인지 알려주는 칼럼
                                    // 자바에는 영향 x

public abstract  class Item {

    @Id @GeneratedValue
    @Column(name ="ITEM_ID")
    private Long id;

    private String name;

    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
