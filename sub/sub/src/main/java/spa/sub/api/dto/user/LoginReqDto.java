package spa.sub.api.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel("UserLoginRequest")
public class LoginReqDto {
    @ApiModelProperty(name="유저 Email", example="BTS@naver.com")
    @Email
    public String email;

    @ApiModelProperty(name="유저 Password", example="your_password")
    @NotNull
    public String password;
}
