package spa.sub.api.service;

import org.springframework.security.core.AuthenticationException;
import spa.sub.api.dto.user.LoginReqDto;
import spa.sub.api.dto.user.RegisterReqDto;
import spa.sub.core.domain.User;

public interface UserService {
    public Long register(RegisterReqDto registerReqDto);
}
