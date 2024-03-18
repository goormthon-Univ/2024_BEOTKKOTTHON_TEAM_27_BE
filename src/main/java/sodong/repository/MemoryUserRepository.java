package sodong.repository;

import org.springframework.stereotype.Repository;
import sodong.domain.User;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository{
    private static Map<Long, User> store = new HashMap<>();
    @Override
    public User save(User user) {
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
