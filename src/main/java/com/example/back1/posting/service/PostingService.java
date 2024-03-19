package com.example.back1.posting.service;

import com.example.back1.posting.domain.Posting;
import com.example.back1.posting.domain.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    @Transactional
    public Posting createPosting(Posting posting) {
        return postingRepository.save(posting);
    }
}
