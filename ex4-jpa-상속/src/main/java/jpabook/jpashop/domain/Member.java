package jpabook.jpashop.domain;


import javax.persistence.*;

@Entity
@DiscriminatorValue("M")// 타입명 변경
public class Member extends BaseEntity{

    private String name;

    @Id
    @GeneratedValue
    @Column(name ="ID")
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
