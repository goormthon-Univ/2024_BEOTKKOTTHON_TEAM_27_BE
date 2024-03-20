package com.example.back1.fastapi.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize
@Getter
public class StoreSimple {
    String name;
    String address;

    public StoreSimple(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
