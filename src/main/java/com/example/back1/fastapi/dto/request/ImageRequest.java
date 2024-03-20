package com.example.back1.fastapi.dto.request;

import com.example.back1.fastapi.dto.response.PromotionSimple;
import com.example.back1.fastapi.dto.response.StoreSimple;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record ImageRequest(
        StoreSimple store,
        PromotionSimple promotion,
        String file_name
) {
}
