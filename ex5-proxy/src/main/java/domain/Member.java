package domain;


import javax.persistence.*;

@Entity
@DiscriminatorValue("M")// 타입명 변경
public class Member extends BaseEntity{

    @Id @Column (name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn (name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
