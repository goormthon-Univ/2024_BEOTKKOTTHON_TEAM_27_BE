package sodong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sodong.domain.Store;
import sodong.domain.User;
import sodong.domain.request.dto.StoreRequestDto;
import sodong.domain.request.dto.UserDto;
import sodong.domain.response.dto.StoreResponseDto;
import sodong.service.StoreService;
import sodong.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;
    private final UserService userService;

    @PostMapping()
    public Long createStore(StoreRequestDto request) {
        User user = userService.findById(request.userId());
        return storeService.enrollStore(Store.createStore(user, request.name(), request.address()));
    }

    @GetMapping()
    public StoreResponseDto getStore(UserDto request) {
        Store store = storeService.findById(request.storeId());
        return new StoreResponseDto(request.userId(), request.storeId(), store.getName(), store.getAddress());
    }
}
