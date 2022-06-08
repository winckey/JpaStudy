package spa.sub.api.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spa.sub.api.dto.common.BaseResponseBody;
import spa.sub.api.dto.user.LoginReqDto;
import spa.sub.api.dto.user.LoginResDto;
import spa.sub.api.exception.UserNotFoundException;
import spa.sub.api.service.UserService;
import spa.sub.config.auth.JwtTokenProvider;
import spa.sub.config.auth.UserAuthentication;
import spa.sub.core.domain.User;
import spa.sub.core.repository.UserRepository;

import javax.validation.Valid;

@Api(value = "인증 API", tags = {"Auth."})
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "<strong>아이디와 패스워드</strong>를 통해 로그인 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = LoginResDto.class),
            @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
            @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<LoginResDto> login(@RequestBody @ApiParam(value="로그인 정보", required = true) LoginReqDto loginReqDto) {
        User user = userRepository.findByEmail(loginReqDto.getEmail()).orElseThrow(() -> new UserNotFoundException());
        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        if(passwordEncoder.matches(loginReqDto.getPassword(), user.getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)

            Authentication authentication = new UserAuthentication(loginReqDto.getEmail(), null, null);
            String token = JwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(LoginResDto.of(200, "Success", token));
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        return ResponseEntity.status(401).body(LoginResDto.of(401, "Invalid Password", null));
    }
}

