package com.example.back1.store.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findStoreByUser_Id(Long userId);
}
