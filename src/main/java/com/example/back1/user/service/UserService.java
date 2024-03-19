package com.example.back1.user.service;

import com.example.back1.user.domain.User;
import com.example.back1.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long createUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public User findById(Long userId) {
        System.out.println("*********************************");
        System.out.println("userId = " + userId);
        System.out.println("*********************************");

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    public User findByLoginId(String loginId) {
        User user = userRepository.findUserByLoginId(loginId).get();
        return user;
    }

    public Long login(String loginId, String password) {
        User user = findByLoginId(loginId);
        if (user.getPassword().equals(password)) {
            return user.getId();
        }
        else {
            return -1L;
        }
    }
}
