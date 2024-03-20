package com.example.back1.posting.service.dto.response;

public record PostingBasicResponse(
        Long userId,
        Long storeId,
        Long postingId
) {
}
