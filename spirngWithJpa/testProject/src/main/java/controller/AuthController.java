package controller;

import Dto.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "인증 API", tags = {"Auth."})
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;


    public User login2(@RequestBody @ApiParam(value="로그인 정보", required = true) User loginReqDto) {
        User user =new User();
        user.setEmail("test@test.com");
        user.setPassword("test");
        user.setName("testName");
        if(user.getEmail().equals(loginReqDto.getEmail()) && user.getPassword().equals(loginReqDto.getPassword())) {
            // 성공시 객체 반환
            return user;
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        return null;
    }



    @PostMapping("/register")
    @ApiOperation(value = "회원 가입", notes = "<strong>이메일과 패스워드</strong>를 통해 회원가입 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "런타임 오류"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public User register(
            @RequestBody @ApiParam(value="회원가입 정보", required = true) @Valid User registerReqDto) {
        return registerReqDto;
    }
}

