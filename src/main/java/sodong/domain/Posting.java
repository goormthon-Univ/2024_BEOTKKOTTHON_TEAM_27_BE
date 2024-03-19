package sodong.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Posting {
    private Long id;
    private Long storeId;
    private Long userId;
    private String type;
    private String channel;

    private String srcFileName;

    private ArrayList<String> targetAge;

    private ArrayList<String> targetGender;
    private String promotionType;
    private String promotionSubject;
    private String promotionContent;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate() {
        this.modifiedDate = LocalDateTime.now();
    }
}
