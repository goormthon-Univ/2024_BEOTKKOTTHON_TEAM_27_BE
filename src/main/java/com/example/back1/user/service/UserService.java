package com.example.back1.user.service;

import com.example.back1.user.domain.User;
import com.example.back1.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
