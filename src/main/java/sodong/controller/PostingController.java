package sodong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sodong.domain.Posting;
import sodong.domain.request.dto.PostingRequestDto;
import sodong.domain.response.dto.PostingResponseDto;
import sodong.service.PostingService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posting")
public class PostingController {
    private final PostingService postingService;

    @Autowired
    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping
    public Optional<Posting> getPosting(@RequestParam Long postingId) {
        return postingService.findOne(postingId);
    }

    @GetMapping("/list")
    public List<Posting> list() {
        return postingService.findPostings();
    }

    @PostMapping
    public PostingResponseDto create(@RequestBody PostingRequestDto postingRequestDto) {
        Posting createdPosting = postingService.createPosting(posting);

        PostingResponseDto responseDto = new PostingResponseDto();
        responseDto.setSuccess(true);
        responseDto.setCode(200);
        responseDto.setMessage("포스팅이 성공적으로 등록되었습니다.");

        PostingResponseDto.PostingDto postingDto = getPostingDto(createdPosting);
        responseDto.setResult(Collections.singletonList(postingDto));

        return responseDto;
    }

    private static PostingResponseDto.PostingDto getPostingDto(Posting createdPosting) {
        PostingResponseDto.PostingDto postingDto = new PostingResponseDto.PostingDto();
        postingDto.setPostingId(createdPosting.getId());
        postingDto.setRequestCount(-1);
        return postingDto;
    }
}
