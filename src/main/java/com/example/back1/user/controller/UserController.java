package com.example.back1.user.controller;

import com.example.back1.store.service.StoreService;
import com.example.back1.user.controller.dto.request.UserForm;
import com.example.back1.user.service.UserService;
import com.example.back1.user.service.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {
    private final UserService userService;
    private final StoreService storeService;

    @GetMapping("/login")
    public LoginResponse login(@RequestBody @Valid UserForm userForm) {
        Long userId = userService.createUser(userForm.toUser());
        Long storeId = storeService.findByUserId(userId);

        return new LoginResponse(userId, storeId);
    }
}
