package com.example.back1.store.controller;

import com.example.back1.store.controller.dto.response.StoreRequestDto;
import com.example.back1.store.domain.Store;
import com.example.back1.store.service.StoreService;
import com.example.back1.store.service.dto.response.StoreCreateResponse;
import com.example.back1.store.service.dto.response.StoreInformation;
import com.example.back1.user.controller.dto.request.UserDto;
import com.example.back1.user.domain.User;
import com.example.back1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;
    private final UserService userService;

    @PostMapping()
    public StoreCreateResponse createStore(StoreRequestDto request) {
        User user = userService.findById(request.userId());
        Store store = storeService.enrollStore(Store.createStore(user, request.name(), request.address()));
        return new StoreCreateResponse(user.getId(), store.getId());
    }

    @GetMapping()
    public StoreInformation getStore(UserDto request) {
        Store store = storeService.findById(request.storeId());
        return new StoreInformation(request.userId(), request.storeId(), store.getName(), store.getAddress());
    }
}
