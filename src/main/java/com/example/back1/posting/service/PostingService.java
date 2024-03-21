package com.example.back1.posting.service;

import com.example.back1.fastapi.dto.request.ImageRequest;
import com.example.back1.fastapi.dto.request.TextRequest;
import com.example.back1.fastapi.dto.response.ImageResponse;
import com.example.back1.fastapi.dto.response.PromotionSimple;
import com.example.back1.fastapi.dto.response.StoreSimple;
import com.example.back1.fastapi.dto.response.TextResponse;
import com.example.back1.posting.domain.Posting;
import com.example.back1.posting.domain.PostingRepository;
import com.example.back1.posting.service.dto.response.PostingInformation;
import com.example.back1.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    @Value("${deploy.base_url}")
    private String FAST_API_URL;

    @Value("${deploy.posting_port}")
    private String POSTING_PORT;

    @Transactional
    public Posting createPosting(Posting posting) {
        return postingRepository.save(posting);
    }

    @Transactional
    public Posting updatePostingText(Posting posting) {
        String updatePostingText = generateText_FastAPI(posting, posting.getStore());
        posting.updatePostingText(updatePostingText);
        return posting;
    }

    @Transactional
    public Posting updatePostingImage(Posting posting) {
        String updatePostingImage = generateImage_FastAPI(posting, posting.getStore());
        posting.updatePostingImage(updatePostingImage);
        return posting;
    }

    public Boolean canModifyText(Posting posting) {
        if (posting.getPostingText_modifiedCount() >= 3) {
            return FALSE;
        }
        return TRUE;
    }

    public Boolean canModifyImage(Posting posting) {
        if (posting.getPostingImage_modifiedCount() >= 3) {
            return FALSE;
        }
        return TRUE;
    }

    private String generateText_FastAPI(Posting posting, Store store) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + FAST_API_URL + ":" + POSTING_PORT + "/api/posting/text";

        TextRequest requestBody = new TextRequest(
                new StoreSimple(store.getName(), store.getAddress()),
                new PromotionSimple(posting.getPostingChannel(), posting.getPromotionType(), posting.getPromotionSubject(), posting.getPromotionContent(), posting.getTargetGender(), posting.getTargetAge())
        );

        TextResponse responseBody = restTemplate.postForObject(url, requestBody, TextResponse.class);
        return responseBody.posting_text();
    }

    private String generateImage_FastAPI(Posting posting, Store store) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://" + FAST_API_URL + ":" + POSTING_PORT + "/api/posting/image";

        ImageRequest requestBody = new ImageRequest(
                new StoreSimple(store.getName(), store.getAddress()),
                new PromotionSimple(posting.getPostingChannel(), posting.getPromotionType(), posting.getPromotionSubject(), posting.getPromotionContent(), posting.getTargetGender(), posting.getTargetAge()),
                posting.getFileName()
        );

        ImageResponse responseBody = restTemplate.postForObject(url, requestBody, ImageResponse.class);
        return responseBody.new_image_url();
    }

    public Posting findById(Long postingId) {
        return postingRepository.findById(postingId).get();
    }

    public List<PostingInformation> findAllById(Long storeId) {
        List<Posting> list = postingRepository.findAllByStore_Id(storeId);

        List<PostingInformation> postingInformationList = list.stream()
                .map(posting -> new PostingInformation(
                        posting.getId(),
                        posting.getPostingType(),
                        posting.getPostingChannel(),
                        posting.getPostingText(),
                        posting.getPostingText_modifiedCount(),
                        posting.getPostingText_createdDate(),
                        posting.getPostingText_modifiedDate(),
                        posting.getPostingImage(),
                        posting.getPostingImage_modifiedCount(),
                        posting.getPostingImage_createdDate(),
                        posting.getPostingImage_modifiedDate()
                ))
                .collect(Collectors.toList());

        return postingInformationList;
    }

    @Transactional
    public void saveAndFlush(Posting posting) {
        postingRepository.saveAndFlush(posting);
    }
}
