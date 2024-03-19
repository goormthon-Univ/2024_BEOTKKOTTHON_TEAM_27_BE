package sodong.domain.request.dto;

import sodong.domain.Posting;

import java.util.ArrayList;

public record PostingRequestDto(
        Long userId,
        Long storeId,
        String postingType,
        String postingChannel,
        ArrayList<String> targetAge,
        ArrayList<String> targetGender,
        String promotionType,
        String promotionSubject,
        String promotionContent,
        String srcFileName
) {
    public Posting toPosting() {
        return Posting.createPosting(
                storeId, postingChannel, targetAge, targetGender, promotionType, promotionSubject, promotionContent, srcFileName
        );
    }
}
