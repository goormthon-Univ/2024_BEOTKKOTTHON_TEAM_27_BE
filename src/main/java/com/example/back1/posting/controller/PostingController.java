package com.example.back1.posting.controller;

import com.example.back1.posting.controller.dto.request.PostingCreateRequest;
import com.example.back1.posting.controller.dto.request.PostingFindRequest;
import com.example.back1.posting.controller.dto.request.PostingModifyRequest;
import com.example.back1.posting.domain.Posting;
import com.example.back1.posting.service.PostingService;
import com.example.back1.posting.service.dto.response.PostingBasicResponse;
import com.example.back1.posting.service.dto.response.PostingFindResponse;
import com.example.back1.posting.service.dto.response.PostingInformation;
import com.example.back1.posting.service.dto.response.PostingListResponse;
import com.example.back1.store.domain.Store;
import com.example.back1.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posting")
public class PostingController {
    private final StoreService storeService;
    private final PostingService postingService;

    @PostMapping("")
    public PostingBasicResponse createPosting(@RequestBody @Valid PostingCreateRequest request) {
        Store store = storeService.findById(request.storeId());
        Posting posting = request.toPosting(store);
        Posting savedPosting = postingService.createPosting(posting);

        postingService.updatePostingText(savedPosting);
        if (request.postingType().equals("Both")) {
            postingService.updatePostingImage(savedPosting);
        }

        return new PostingBasicResponse(request.userId(), store.getId(), savedPosting.getId());
    }

    @PutMapping("")
    public PostingBasicResponse updatePosting(@RequestBody @Valid PostingModifyRequest request) {
        Posting posting = postingService.findById(request.postingId());

        if (request.modifyTarget().equals("Text")) {
            postingService.updatePostingText(posting);
        } else if (request.modifyTarget().equals("Image")) {
            postingService.updatePostingImage(posting);
        }

        return new PostingBasicResponse(request.userId(), request.userId(), request.postingId());
    }

    @GetMapping("")
    public PostingFindResponse getPosting(@RequestBody @Valid PostingFindRequest request) {
        Posting posting = postingService.findById(request.postingId());
        return new PostingFindResponse(request.userId(), request.storeId(), new PostingInformation(request.postingId(), posting.getPostingType(), posting.getPostingChannel(), posting.getPostingText(), posting.getPostingText_createdTime(), posting.getPostingText_modifiedTime(), posting.getPostingImage(), posting.getPostingImage_createdTime(), posting.getPostingImage_modifiedTime()));
    }

    @GetMapping("/list/{userId}/{storeId}")
    public PostingListResponse getPostingList(@PathVariable Long userId, @PathVariable Long storeId) {
        List<PostingInformation> postingList = postingService.findAllById(storeId);
        return new PostingListResponse(userId, storeId, postingList);
    }
}
