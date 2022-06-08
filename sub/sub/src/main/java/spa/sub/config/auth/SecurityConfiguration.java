package spa.sub.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;
import spa.sub.core.repository.UserRepository;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final CorsFilter corsFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 사용 하지않음
                .and()
                .addFilter(corsFilter) //HTTP 요청에 JWT 토큰 인증 필터를 거치도록 필터를 추가 @CrossOrigin(인증 X), 시큐리티 필터에 등록(인증 O)
                .authorizeRequests()
                .antMatchers("/api/v1/users/me").authenticated()       // 이 주소로 들어오면 인증이 필요하다.
                .antMatchers("/api/admin/**").access("hasRole('ADMIN')") // 이 주소로 들어오려면 ADMIN 권한이 필요하다.
                .anyRequest().permitAll()
                .and().cors();
    }

    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

}
