package com.example.back1.posting.controller;

import com.example.back1.store.service.StoreService;
import com.example.back1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posting")
public class PostingController {
    private final UserService userService;
    private final StoreService storeService;

}
