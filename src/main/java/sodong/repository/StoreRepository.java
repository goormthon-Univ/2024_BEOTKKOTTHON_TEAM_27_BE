package sodong.repository;

import sodong.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {
    Store save(Store store);
    Optional<Store> findById(Long id);
    List<Store> findAll();
}
