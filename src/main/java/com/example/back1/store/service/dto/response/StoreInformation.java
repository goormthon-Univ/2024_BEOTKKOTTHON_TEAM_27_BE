package com.example.back1.store.service.dto.response;

public record StoreInformation(
        Long userId,
        Long storeId,
        String name,
        String address
) {
}
