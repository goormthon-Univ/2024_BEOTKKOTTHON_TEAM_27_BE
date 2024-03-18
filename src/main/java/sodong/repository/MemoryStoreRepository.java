package sodong.repository;

import org.springframework.stereotype.Repository;
import sodong.domain.Store;

import java.util.*;
@Repository
public class MemoryStoreRepository implements StoreRepository{
    private static Map<Long, Store> storeMap = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Store save(Store store) {
        store.setId(++sequence);
        store.setCreatedDate();
        store.setModifiedDate();
        storeMap.put(store.getId(), store);
        return store;
    }

    @Override
    public Optional<Store> findById(Long id) {
        return Optional.ofNullable(storeMap.get(id));
    }

    @Override
    public List<Store> findAll() {
        return new ArrayList<>(storeMap.values());
    }
}
