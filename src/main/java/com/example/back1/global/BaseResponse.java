package com.example.back1.global;

public record BaseResponse(
        Boolean isSuccess,
        String code,
        String message,
        Object data
) {
}
