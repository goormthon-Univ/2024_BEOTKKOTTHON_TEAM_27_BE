package sodong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sodong.domain.Posting;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
}
