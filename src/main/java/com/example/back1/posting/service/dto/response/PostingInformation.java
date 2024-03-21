package com.example.back1.posting.service.dto.response;

import java.time.LocalDateTime;

public record PostingInformation(
        Long postingId,

        String postingType,
        String postingChannel,

        String postingText,
        Long postingText_modifiedCount,
        LocalDateTime postingText_createdDate,
        LocalDateTime postingText_modifiedDate,

        String postingImage,
        Long postingImage_modifiedCount,
        LocalDateTime postingImage_createdDate,
        LocalDateTime postingImage_modifiedDate
) {
}
