package spa.sub.api.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spa.sub.api.dto.common.BaseResponseBody;
import spa.sub.api.dto.user.LoginReqDto;
import spa.sub.api.dto.user.RegisterReqDto;
import spa.sub.api.service.UserService;
import spa.sub.core.repository.UserRepository;

import javax.validation.Valid;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/register")
    @ApiOperation(value = "회원 가입", notes = "<strong>이메일과 패스워드</strong>를 통해 회원가입 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "런타임 오류"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody @ApiParam(value="회원가입 정보", required = true) @Valid RegisterReqDto registerReqDto) {
        userService.register(registerReqDto);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
