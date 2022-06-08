package spa.sub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spa.sub.core.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
