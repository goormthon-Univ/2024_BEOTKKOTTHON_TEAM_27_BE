package com.example.back1.posting.service;

import com.example.back1.dto.response.ImageResponse;
import com.example.back1.dto.response.TextResponse;
import com.example.back1.fastapi.dto.request.ImageRequest;
import com.example.back1.fastapi.dto.request.TextRequest;
import com.example.back1.posting.domain.Posting;
import com.example.back1.posting.domain.PostingRepository;
import com.example.back1.posting.service.dto.response.PostingInformation;
import com.example.back1.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    private final String FAST_API_URL = "http://158.180.66.224";
    private final String POSTING_PORT = "8001";

    @Transactional
    public Posting createPosting(Posting posting) {
        return postingRepository.save(posting);
    }

    @Transactional
    public void updatePostingText(Posting posting) {
        String postingText = generateText_FastAPI(posting, posting.getStore());
        posting.updatePostingText(postingText);
    }

    @Transactional
    public void updatePostingImage(Posting posting) {
        String postingImage = generateImage_FastAPI(posting, posting.getStore());
        posting.updatePostingImage(postingImage);
    }

    private String generateText_FastAPI(Posting posting, Store store) {
        RestTemplate restTemplate = new RestTemplate();
        String url = FAST_API_URL + ":" + POSTING_PORT + "/api/posting/text";

        TextRequest requestBody = new TextRequest(new TextRequest.Store(store.getName(), store.getAddress()),
                new TextRequest.Promotion(posting.getPostingChannel(), posting.getPromotionType(), posting.getPromotionSubject(), posting.getPromotionContent(), posting.getTargetGender(), posting.getTargetAge()));

        TextResponse responseBody = restTemplate.postForObject(url, requestBody, TextResponse.class);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(responseBody);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");

        return responseBody.posting_text();
    }

    private String generateImage_FastAPI(Posting posting, Store store) {
        RestTemplate restTemplate = new RestTemplate();
        String url = FAST_API_URL + ":" + POSTING_PORT + "/api/posting/image";

        ImageRequest requestBody = new ImageRequest(new ImageRequest.Store(store.getName(), store.getAddress()),
                new ImageRequest.Promotion(posting.getPostingChannel(), posting.getPromotionType(), posting.getPromotionSubject(), posting.getPromotionContent(), posting.getTargetGender(), posting.getTargetAge()),
                posting.getFileName());

        ImageResponse responseBody = restTemplate.postForObject(url, requestBody, ImageResponse.class);
        return responseBody.new_image_url();
    }

    public void updatePostingText() {

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
                        posting.getPostingText_createdTime(),
                        posting.getPostingText_modifiedTime(),
                        posting.getPostingImage(),
                        posting.getPostingImage_createdTime(),
                        posting.getPostingImage_modifiedTime()
                ))
                .collect(Collectors.toList());

        return postingInformationList;
    }
}
