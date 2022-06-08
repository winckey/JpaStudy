package spa.sub.api.dto.user;

import lombok.*;
import spa.sub.core.domain.User;
import spa.sub.core.domain.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterReqDto {
    @Email
    public String email;
    @NotNull
    public String position;
    @NotNull
    public String department;
    @NotNull
    public String name;
    @NotNull
    public String password;
    private UserRole role = UserRole.USER;

    public User toEntity(){
        return User.builder()
                .email(email)
                .position(position)
                .department(department)
                .name(name)
                .password(password)
                .role(role)
                .build();
    }
}
