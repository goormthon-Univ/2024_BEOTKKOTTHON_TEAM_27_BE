package com.example.back1.fastapi.dto.request;

public record ImageRequest(
        Store store,
        Promotion promotion,
        String file_name
) {
    public static class Store {
        String name;
        String address;

        public Store(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    public static class Promotion {
        String channel;
        String type;
        String subject;
        String content;
        String targetGender;
        String targetAge;

        public Promotion(String channel, String type, String subject, String content, String targetGender, String targetAge) {
            this.channel = channel;
            this.type = type;
            this.subject = subject;
            this.content = content;
            this.targetGender = targetGender;
            this.targetAge = targetAge;
        }
    }
}
