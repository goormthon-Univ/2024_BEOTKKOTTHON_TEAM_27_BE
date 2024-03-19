package sodong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sodong.domain.User;
import sodong.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long join(User user) {
        validateDuplicateUser(user, userRepository);
        userRepository.save(user);
        return user.getId();
    }

    private static void validateDuplicateUser(User user, UserRepository userRepository) {
        userRepository.findById(user.getId()).
                ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
