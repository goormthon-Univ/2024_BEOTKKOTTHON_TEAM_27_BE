package sodong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sodong.domain.request.dto.UserForm;
import sodong.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public Long login(@RequestBody @Valid UserForm userForm) {
        return userService.createUser(userForm.toUser());
    }
}
