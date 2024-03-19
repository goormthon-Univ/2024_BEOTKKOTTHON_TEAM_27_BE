package sodong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sodong.domain.Store;
import sodong.repository.StoreRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public Long enrollStore(Store store) {
        return storeRepository.save(store).getId();
    }

    public Store findById(Long storeId) {
        return storeRepository.findById(storeId).get();
    }
}
