package com.example.back1.posting.controller.dto.request;

public record PostingFindRequest(
        Long userId,
        Long storeId,
        Long postingId
) {
}
