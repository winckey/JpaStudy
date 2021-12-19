package domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("M")// 타입명 변경
public class Member extends BaseEntity{

    private String name;

    @Id
    @GeneratedValue
    @Column(name ="ID")
    private Long id;

    //period
//    private LocalDateTime startDate;
//
//    private LocalDateTime EndDate;
    @Embedded
    private Period period;
    
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD" , joinColumns = @JoinColumn(name = "MEMBER_ID"))//외래키 지정
    @Column(name = "FOOD_NAME")
    private Set<String> favaoriteFoods = new HashSet<>();

    public Set<String> getFavaoriteFoods() {
        return favaoriteFoods;
    }

    public void setFavaoriteFoods(Set<String> favaoriteFoods) {
        this.favaoriteFoods = favaoriteFoods;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }


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
