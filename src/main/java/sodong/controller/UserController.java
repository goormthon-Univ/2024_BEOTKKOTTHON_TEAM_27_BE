package sodong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sodong.domain.User;
import sodong.domain.UserForm;
import sodong.repository.UserRepository;
import sodong.security.JwtTokenProvider;
import sodong.service.UserService;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Optional<User> getUser(@RequestParam Long userId){
        return userService.findOne(userId);
    }
    @GetMapping("/api/user/all")
    public List<User> list(){
        return userService.findUsers();
    }
    @PostMapping("/api/user")
    public void create(@RequestBody UserForm userForm){
        User user = new User();
        user.setId(userForm.getUserId());
        user.setPassword(userForm.getPassword());
        userService.join(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(user.getId(), member.getRoles());
    }
}
