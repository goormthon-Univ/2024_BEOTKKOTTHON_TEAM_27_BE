package com.example.back1.fastapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize
@Getter
public class PromotionSimple {
    String channel;
    String type;
    String subject;
    String content;
    String targetGender;
    String targetAge;

    public PromotionSimple(String channel, String type, String subject, String content, String targetGender, String targetAge) {
        this.channel = channel;
        this.type = type;
        this.subject = subject;
        this.content = content;
        this.targetGender = targetGender;
        this.targetAge = targetAge;
    }
}
