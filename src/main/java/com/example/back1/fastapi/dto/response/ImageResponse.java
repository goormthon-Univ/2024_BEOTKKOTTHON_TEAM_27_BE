package com.example.back1.fastapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record ImageResponse(
        String new_image_url,
        String kogpt_response
) {
}
