package sodong.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String address;

    @Builder
    public Store(User user, String name, String address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }

    public static Store createStore(User user, String name, String address) {
        return Store.builder()
                .user(user)
                .name(name)
                .address(address)
                .build();
    }
}
