package spa.sub.config.auth;

//시큐리티가 설정된 url을 낚아채서 로그인을 진행시킨다.
//로그인 완료되면 시큐리티 세션을 만들어준다. (Security ContextHolder)
//오브젝트 타입 -> Authentication 타입 객체
//Authentication 안에 User 정보가 있어야 한다.
//User 오브젝트 타입 -> UserDetails 타입 객체

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spa.sub.core.domain.User;

import java.util.ArrayList;
import java.util.Collection;

// Security Session -> Authentication -> UserDetails
@Getter
public class PrincipalDetails implements UserDetails {

    private User user;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialNonExpired;
    boolean enabled = false;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().name();
            }
        });
        return null;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }
    @Override
    public String getUsername() {
        return this.user.getEmail();
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
