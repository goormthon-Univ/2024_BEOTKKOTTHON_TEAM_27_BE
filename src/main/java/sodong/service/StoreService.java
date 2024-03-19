package sodong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sodong.domain.Store;
import sodong.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public Store enrollStore(Store store) {
        validateDuplicateStore(store, storeRepository);
        return storeRepository.save(store);
    }

    private static void validateDuplicateStore(Store store, StoreRepository storeRepository) {
        storeRepository.findById(store.getId()).
                ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 가게입니다.");
                });
    }

    public List<Store> findStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> findOne(Long storeId) {
        return storeRepository.findById(storeId);
    }
}
