package sodong.repository;

import org.springframework.stereotype.Repository;
import sodong.domain.Posting;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostingRepository {
    Posting save(Posting store);
    Optional<Posting> findById(Long id);
    List<Posting> findAll();
}
