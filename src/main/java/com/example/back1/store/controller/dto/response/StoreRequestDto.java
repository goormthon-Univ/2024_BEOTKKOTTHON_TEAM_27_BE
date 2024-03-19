package com.example.back1.store.controller.dto.response;


public record StoreRequestDto(
        Long userId,
        String name,
        String address
) {
}
