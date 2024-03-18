package sodong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sodong.domain.User;
import sodong.domain.UserForm;
import sodong.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Optional<User> getUser(@RequestParam Long userId){
        return userService.findOne(userId);
    }
    @GetMapping("/all")
    public List<User> list(){
        return userService.findUsers();
    }
    @PostMapping
    public void create(@RequestBody UserForm userForm){
        User user = new User();
        user.setId(userForm.getUserId());
        user.setPassword(userForm.getPassword());
        userService.join(user);
    }
}
