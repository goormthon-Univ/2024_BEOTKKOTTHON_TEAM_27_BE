package sodong.repository;

import org.springframework.stereotype.Repository;
import sodong.domain.Posting;

import java.util.*;

@Repository
public class MemoryPostingRepository implements PostingRepository{
    private static Map<Long, Posting> postingMap = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Posting save(Posting posting) {
        posting.setId(++sequence);
        posting.setCreatedDate();
        posting.setModifiedDate();
        postingMap.put(posting.getId(), posting);
        return posting;
    }

    @Override
    public Optional<Posting> findById(Long id) {return Optional.ofNullable(postingMap.get(id));}

    @Override
    public List<Posting> findAll() {return new ArrayList<>(postingMap.values());}
}
