package com.example.back1.posting.controller.dto.request;

public record PostingModifyRequest(
        Long userId,
        Long postingId,
        String modifyTarget
) {
}
