package spa.sub.core.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@QueryEntity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    Long id;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String position;
    @Column(nullable = false)
    String department;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(String email, String position, String department, String name, String password, UserRole role) {
        this.email = email;
        this.position = position;
        this.department = department;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
