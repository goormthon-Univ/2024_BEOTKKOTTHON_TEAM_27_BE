package sodong.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String password;

    @Builder
    public User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public static User createUser(String loginId, String password) {
        return User.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }
}
