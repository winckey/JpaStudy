package japHello4;

import javax.persistence.*;


@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    //    @Column(name = "TEAM_ID")
//    private Long teamId;


    @ManyToOne
    @JoinColumn(name = "TEAM_ID")//fk가 머냐? team객체중에 (team id)
                                 //자바내의 객체와는 상관없음 디비와만 비교하기 때문
    private Team team;//////객체지향적인 설계 외래키의 관계를 표현하는방법

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}