package com.example.back1.posting.service.dto.response;

import java.util.List;

public record PostingListResponse(
        Long userId,
        Long storeId,
        List<PostingInformation> postingList
) {
}
