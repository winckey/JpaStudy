package spa.sub.config.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spa.sub.core.domain.User;
import spa.sub.core.repository.UserRepository;

// Authentication
// 설정된 login url에서 login 요청이 오면 UserDetailsService로 Ioc 되어있는 loadUserByUsername 실행
@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("없는 회원 입니다."));
        return new PrincipalDetails(user);
    }
}
