package sodong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sodong.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
