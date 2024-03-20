package com.example.back1.posting.service.dto.response;

public record PostingFindResponse(
        Long userId,
        Long storeId,
        PostingInformation posting
) {
}
