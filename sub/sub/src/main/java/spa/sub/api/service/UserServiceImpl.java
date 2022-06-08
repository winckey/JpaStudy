package spa.sub.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spa.sub.api.dto.user.LoginReqDto;
import spa.sub.api.dto.user.RegisterReqDto;
import spa.sub.core.domain.User;
import spa.sub.core.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ValidationCheck validationCheck;
    private final PasswordEncoder passwordEncoder;

    public Long register(RegisterReqDto registerReqDto){
        validationCheck.validateDuplicate(userRepository.findByEmail(registerReqDto.getEmail()));
        registerReqDto.setPassword(passwordEncoder.encode(registerReqDto.getPassword()));
        return userRepository.save(registerReqDto.toEntity()).getId();
    }
}
