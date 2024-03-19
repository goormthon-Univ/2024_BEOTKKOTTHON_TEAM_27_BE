package sodong.domain.request.dto;

import sodong.domain.User;

public record UserForm (
        String loginId,
        String password
) {
    public User toUser() {
        return User.createUser(loginId, password);
    }
}
