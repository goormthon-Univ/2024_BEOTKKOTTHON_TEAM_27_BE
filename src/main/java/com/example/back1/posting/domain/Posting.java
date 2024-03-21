package com.example.back1.posting.domain;

import com.example.back1.global.BaseTimeEntity;
import com.example.back1.store.domain.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "posting")
public class Posting extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    private String postingType;
    private String postingChannel; // Instagram, Daangn, KakaoChannel, KakaoMap

    private String targetAge; // 10대, 20대, 30대, 40대, 50대, 기타
    private String targetGender; // 남자, 여자

    private String promotionType; // menu, event
    private String promotionSubject;
    private String promotionContent;

    private String fileName;

    private String postingText = null;
    private Long postingText_modifiedCount = 0L;
    private LocalDateTime postingText_createdDate;
    private LocalDateTime postingText_modifiedDate;

    private String postingImage = null;
    private Long postingImage_modifiedCount = 0L;
    private LocalDateTime postingImage_createdDate;
    private LocalDateTime postingImage_modifiedDate;

    @Builder
    public Posting(Store store, String postingType, String postingChannel, String targetAge,
                   String targetGender, String promotionType, String promotionSubject,
                   String promotionContent, String fileName) {
        this.store = store;
        this.postingType = postingType;
        this.postingChannel = postingChannel;
        this.targetAge = targetAge;
        this.targetGender = targetGender;
        this.promotionType = promotionType;
        this.promotionSubject = promotionSubject;
        this.promotionContent = promotionContent;
        this.fileName = fileName;

        this.postingText = null;
        this.postingText_modifiedCount = 0L;
        this.postingText_createdDate = null;
        this.postingText_modifiedDate = null;

        this.postingImage = null;
        this.postingImage_modifiedCount = 0L;
        this.postingImage_createdDate = null;
        this.postingImage_modifiedDate = null;
    }

    public static Posting createPosting(Store store, String postingType, String postingChannel, String targetAge,
                                        String targetGender, String promotionType, String promotionSubject,
                                        String promotionContent, String fileName) {
        return Posting.builder()
                .store(store)
                .postingType(postingType)
                .postingChannel(postingChannel)
                .targetAge(targetAge)
                .targetGender(targetGender)
                .promotionType(promotionType)
                .promotionSubject(promotionSubject)
                .promotionContent(promotionContent)
                .fileName(fileName)
                .build();
    }

    public void updatePostingText(String postingText) {
        this.postingText = postingText;

        if (this.postingText_modifiedCount == 0) {
            this.postingText_createdDate = LocalDateTime.now();
        }
        this.postingText_modifiedDate = LocalDateTime.now();

        this.postingText_modifiedCount++;
    }

    public void updatePostingImage(String postingImage) {
        this.postingImage = postingImage;

        if (this.postingImage_modifiedCount == 0) {
            this.postingImage_createdDate = LocalDateTime.now();
        }
        this.postingImage_modifiedDate = LocalDateTime.now();

        this.postingImage_modifiedCount++;
    }
}
