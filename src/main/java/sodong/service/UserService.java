package sodong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sodong.domain.User;
import sodong.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long createUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).get();
    }
}
