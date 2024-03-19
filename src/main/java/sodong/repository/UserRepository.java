package sodong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sodong.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
