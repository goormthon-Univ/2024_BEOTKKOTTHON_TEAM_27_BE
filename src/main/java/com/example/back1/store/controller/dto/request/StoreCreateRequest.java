package com.example.back1.store.controller.dto.request;


public record StoreCreateRequest(
        Long userId,
        String name,
        String address
) {
}
