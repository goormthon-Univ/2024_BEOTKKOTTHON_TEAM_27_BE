package com.example.back1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class Back1Application {
    public static void main(String[] args) {
        SpringApplication.run(Back1Application.class, args);
    }
}
