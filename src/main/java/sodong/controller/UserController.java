package sodong.controller;

//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sodong.domain.User;
import sodong.domain.UserForm;
//import sodong.repository.UserRepository;
//import sodong.security.JwtTokenProvider;
import sodong.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@RequiredArgsConstructor
@RestController
public class UserController {
//    private final PasswordEncoder passwordEncoder;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserRepository userRepository;
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
    public String login(@RequestBody Map<String, String> userCredentials) {
        String id = userCredentials.get("id");
        String password = userCredentials.get("password");

        // ID와 비밀번호가 모두 제공되었는지 확인
        if (id == null || password == null) {
            return "로그인 실패: ID 또는 비밀번호가 누락되었습니다.";
        }

        // 주어진 ID로 사용자를 찾음
        Optional<User> userOptional = userService.findOne(Long.parseLong(id));

        // 사용자가 존재하고, 비밀번호가 일치하는지 확인
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            return "로그인 성공";
        } else {
            return "로그인 실패: ID 또는 비밀번호가 잘못되었습니다.";
        }
    }
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> user) {
//        User member = userRepository.findByEmail(user.get("email"))
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
//        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
//        return jwtTokenProvider.createToken(user.getId(), member.getRoles());
//    }
}
