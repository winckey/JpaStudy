package spa.sub.api.service;

import spa.sub.api.exception.UserNotFoundException;
import spa.sub.core.domain.User;

import java.util.Optional;

public class ValidationCheck {

    //유효한 회원인지 검증
    public User getUser(Optional<User> user) {
        return user.orElseThrow(() -> new UserNotFoundException());
    }

    // 중복 회원 검사
    public void validateDuplicate(Optional<User> user){
        user.ifPresent(exist -> {
            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
        });
    }


}
