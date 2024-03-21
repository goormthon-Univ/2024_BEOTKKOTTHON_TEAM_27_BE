package com.example.back1.posting.controller;

import com.example.back1.global.BaseResponse;
import com.example.back1.posting.controller.dto.request.PostingCreateRequest;
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
    public BaseResponse createPosting(@RequestBody @Valid PostingCreateRequest request) {
        Store store = storeService.findById(request.storeId());
        Posting posting = request.toPosting(store);

        postingService.updatePostingText(posting);
        if (request.postingType().equals("Both")) {
            postingService.updatePostingImage(posting);
        }
        Posting savedPosting = postingService.createPosting(posting);

        return new BaseResponse(
                Boolean.TRUE,
                "200",
                "OK",
                new PostingBasicResponse(request.userId(), store.getId(), savedPosting.getId())
        );
    }

    @PutMapping("")
    public BaseResponse updatePosting(@RequestBody @Valid PostingModifyRequest request) {
        Posting posting = postingService.findById(request.postingId());
        Boolean canModify = Boolean.FALSE;

        if ("Text".equals(request.modifyTarget())) {
            canModify = postingService.canModifyText(posting);
            if (canModify) {
                posting = postingService.updatePostingText(posting);
                postingService.saveAndFlush(posting);
            }
        } else if ("Image".equals(request.modifyTarget())) {
            canModify = postingService.canModifyImage(posting);
            if (canModify) {
                posting = postingService.updatePostingImage(posting);
                postingService.saveAndFlush(posting);
            }
        }

        String message = canModify ? "OK" : request.modifyTarget() + "을 3번을 초과하여 수정할 수 없습니다.";

        return new BaseResponse(
                canModify,
                "200",
                message,
                new PostingBasicResponse(request.userId(), request.userId(), request.postingId()));
    }

    @GetMapping("/{userId}/{storeId}/{postingId}")
    public BaseResponse getPosting(@PathVariable Long userId, @PathVariable Long storeId, @PathVariable Long postingId) {
        Posting posting = postingService.findById(postingId);

        return new BaseResponse(
                Boolean.TRUE,
                "200",
                "OK",
                new PostingFindResponse(userId, storeId, new PostingInformation(postingId, posting.getPostingType(), posting.getPostingChannel(),
                        posting.getPostingText(), posting.getPostingText_modifiedCount(), posting.getPostingText_createdDate(), posting.getPostingText_modifiedDate(),
                        posting.getPostingImage(), posting.getPostingImage_modifiedCount(), posting.getPostingImage_createdDate(), posting.getPostingImage_modifiedDate()))
        );
    }

    @GetMapping("/list/{userId}/{storeId}")
    public BaseResponse getPostingList(@PathVariable Long userId, @PathVariable Long storeId) {
        List<PostingInformation> postingList = postingService.findAllById(storeId);
        return new BaseResponse(
                Boolean.TRUE,
                "200",
                "OK",
                new PostingListResponse(userId, storeId, postingList)
        );
    }
}
