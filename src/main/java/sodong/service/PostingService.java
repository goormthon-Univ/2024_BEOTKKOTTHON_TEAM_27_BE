package sodong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sodong.domain.Posting;
import sodong.repository.PostingRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    public Posting createPosting(Posting posting) {
        validateDuplicatePosting(posting, postingRepository);
        return postingRepository.save(posting);
    }

    private static void validateDuplicatePosting(Posting posting, PostingRepository postingRepository) {
        postingRepository.findById(posting.getId()).ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 포스팅입니다.");
                }
        );
    }

    public List<Posting> findPostings() {
        return postingRepository.findAll();
    }

    public Optional<Posting> findOne(Long postingId) {
        return postingRepository.findById(postingId);
    }
}
