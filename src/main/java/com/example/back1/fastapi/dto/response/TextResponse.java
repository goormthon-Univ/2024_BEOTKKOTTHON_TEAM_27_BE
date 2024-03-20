package com.example.back1.fastapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record TextResponse(
        String posting_text
) {
}
