package com.example.back1.posting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByStore_Id(Long storeId);
}
