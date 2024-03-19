package sodong.domain;

import java.util.ArrayList;

public class PostingRequestDto {
    private String postingType;
    private String postingChannel;
    private String promotionType;
    private ArrayList<String> targetAge;
    private ArrayList<String> targetGender;


    private String promotionSubject;
    private String promotionContent;
    private String srcFileName;
    private Long storeId;
    private Long userId;

    public String getPostingType() {
        return postingType;
    }

    public void setPostingType(String postingType) {
        this.postingType = postingType;
    }

    public String getPostingChannel() {
        return postingChannel;
    }

    public void setPostingChannel(String postingChannel) {
        this.postingChannel = postingChannel;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionSubject() {
        return promotionSubject;
    }

    public void setPromotionSubject(String promotionSubject) {
        this.promotionSubject = promotionSubject;
    }

    public String getPromotionContent() {
        return promotionContent;
    }

    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }

    public String getSrcFileName() {
        return srcFileName;
    }

    public void setSrcFileName(String srcFileName) {
        this.srcFileName = srcFileName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ArrayList<String> getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(ArrayList<String> targetAge) {
        this.targetAge = targetAge;
    }

    public ArrayList<String> getTargetGender() {
        return targetGender;
    }

    public void setTargetGender(ArrayList<String> targetGender) {
        this.targetGender = targetGender;
    }
}

