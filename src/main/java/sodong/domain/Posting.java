package sodong.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

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
    private Long storeId;

    private String channel; // Instagram, Daangn, KakaoChannel, KakaoMap

    private ArrayList<String> targetAge; // 10대, 20대, 30대, 40대, 50대, 기타
    private ArrayList<String> targetGender; // 남자, 여자

    private String promotionType; // menu, event
    private String promotionSubject;
    private String promotionContent;

    private String srcFileName;

    @Builder
    public Posting(Long id, Long storeId, String channel, ArrayList<String> targetAge,
                   ArrayList<String> targetGender, String promotionType, String promotionSubject,
                   String promotionContent, String srcFileName) {
        this.id = id;
        this.storeId = storeId;
        this.channel = channel;
        this.targetAge = targetAge;
        this.targetGender = targetGender;
        this.promotionType = promotionType;
        this.promotionSubject = promotionSubject;
        this.promotionContent = promotionContent;
        this.srcFileName = srcFileName;
    }

    public static Posting createPosting(Long storeId, String channel, ArrayList<String> targetAge,
                                        ArrayList<String> targetGender, String promotionType, String promotionSubject,
                                        String promotionContent, String srcFileName) {
        return Posting.builder()
                .storeId(storeId)
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
