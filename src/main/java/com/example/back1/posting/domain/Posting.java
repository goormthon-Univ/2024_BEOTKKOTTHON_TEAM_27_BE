package com.example.back1.posting.domain;

import com.example.back1.global.BaseTimeEntity;
import com.example.back1.store.domain.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "posting")
public class Posting extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    private String channel; // Instagram, Daangn, KakaoChannel, KakaoMap

    private String targetAge; // 10대, 20대, 30대, 40대, 50대, 기타
    private String targetGender; // 남자, 여자

    private String promotionType; // menu, event
    private String promotionSubject;
    private String promotionContent;

    private String srcFileName;

    @Builder
    public Posting(Store store, String channel, String targetAge,
                   String targetGender, String promotionType, String promotionSubject,
                   String promotionContent, String srcFileName) {
        this.store = store;
        this.channel = channel;
        this.targetAge = targetAge;
        this.targetGender = targetGender;
        this.promotionType = promotionType;
        this.promotionSubject = promotionSubject;
        this.promotionContent = promotionContent;
        this.srcFileName = srcFileName;
    }

    public static Posting createPosting(Store store, String channel, String targetAge,
                                        String targetGender, String promotionType, String promotionSubject,
                                        String promotionContent, String srcFileName) {
        return Posting.builder()
                .store(store)
                .channel(channel)
                .targetAge(targetAge)
                .targetGender(targetGender)
                .promotionType(promotionType)
                .promotionSubject(promotionSubject)
                .promotionContent(promotionContent)
                .srcFileName(srcFileName)
                .build();
    }
}
