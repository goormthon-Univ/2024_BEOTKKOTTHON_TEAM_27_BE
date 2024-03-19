package sodong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sodong.domain.Posting;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
