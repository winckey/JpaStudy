package jpaHello;

import javax.persistence.Entity;
import javax.persistence.Id;


//@/Entity//jap가 인식하게하는 어노테이션
//@table(name =" test") 로 맵핑이 필요할경우 추가로 할수있다.(id도 동일하게 가능)
class Member {

    @Id//pk를 인식하기위한 어노테이션
    private Long id;
    private String name;

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

}
