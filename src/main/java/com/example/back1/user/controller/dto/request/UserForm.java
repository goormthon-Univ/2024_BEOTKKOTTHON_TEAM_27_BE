package com.example.back1.user.controller.dto.request;

import com.example.back1.user.domain.User;

public record UserForm (
        String loginId,
        String password
) {
    public User toUser() {
        return User.createUser(loginId, password);
    }
}
