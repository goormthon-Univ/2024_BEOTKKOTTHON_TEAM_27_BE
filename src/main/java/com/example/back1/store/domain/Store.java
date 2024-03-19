package com.example.back1.store.domain;

import com.example.back1.global.BaseTimeEntity;
import com.example.back1.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "store")
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    private String name;

    private String address;

    @Builder
    private Store(User user, String name, String address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }

    public static Store createStore(User user, String name, String address) {
        return Store.builder()
                .user(user)
                .name(name)
                .address(address)
                .build();
    }
}
