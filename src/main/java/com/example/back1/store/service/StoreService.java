package com.example.back1.store.service;

import com.example.back1.store.domain.Store;
import com.example.back1.store.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public Store enrollStore(Store store) {
        return storeRepository.save(store);
    }

    public Store findById(Long storeId) {
        return storeRepository.findById(storeId).get();
    }

    public Long findByUserId(Long userId) {
        return storeRepository.findStoreByUser_Id(userId)
                .map(Store::getId)
                .orElse(-1L);
    }
}
