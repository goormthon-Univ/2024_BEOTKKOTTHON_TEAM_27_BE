package sodong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sodong.domain.Store;
import sodong.domain.StoreRequestDto;
import sodong.domain.StoreResponseDto;
import sodong.domain.StoreViewResponseDto;
import sodong.service.StoreService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService){this.storeService = storeService;}
    @GetMapping
    public StoreViewResponseDto getStore(@RequestParam Long storeId) {
        Store selectedStore = storeService.findOne(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        StoreViewResponseDto.StoreDto storeDto = new StoreViewResponseDto.StoreDto();
        storeDto.setStoreId(selectedStore.getId());
        storeDto.setUserId(selectedStore.getUserId());
        storeDto.setName(selectedStore.getName());
        storeDto.setAddress(selectedStore.getAddress());
        storeDto.setPhone(selectedStore.getPhone());
        storeDto.setOperationHours(selectedStore.getOperationHours());
        storeDto.setCreatedDate(selectedStore.getCreatedDate());
        storeDto.setModifiedDate(selectedStore.getModifiedDate());

        StoreViewResponseDto responseDto = new StoreViewResponseDto();
        responseDto.setSuccess(true);
        responseDto.setCode(200);
        responseDto.setMessage("가게 정보 조회에 성공했습니다.");
        responseDto.setResult(List.of(storeDto));

        return responseDto;
    }
    @GetMapping("/all")
    public List<Store> list(){return storeService.findStores();}
    @PostMapping
    public StoreResponseDto create(@RequestBody StoreRequestDto storeRequestDto){
        Store store = new Store();
        store.setUserId(storeRequestDto.getUserId());
        store.setAddress(storeRequestDto.getAddress());
        store.setName(storeRequestDto.getName());
        store.setOperationHours(storeRequestDto.getOperationHours());

        Store createdStore = storeService.enrollStore(store);

        StoreResponseDto responseDto = new StoreResponseDto();
        responseDto.setSuccess(true);
        responseDto.setCode(200);
        responseDto.setMessage("가게가 성공적으로 등록되었습니다.");

        StoreResponseDto.StoreDto storeDto = getStoreDto(createdStore);

        responseDto.setResult(Collections.singletonList(storeDto));

        return responseDto;

    }

    private static StoreResponseDto.StoreDto getStoreDto(Store createdStore) {
        StoreResponseDto.StoreDto storeDto = new StoreResponseDto.StoreDto();
        storeDto.setStoreId(createdStore.getId());
        storeDto.setUserId(createdStore.getUserId());
        storeDto.setName(createdStore.getName());
        storeDto.setAddress(createdStore.getAddress());
        storeDto.setPhone(createdStore.getPhone());
        storeDto.setOperationHours(createdStore.getOperationHours());
        storeDto.setCreatedDate(createdStore.getCreatedDate());
        storeDto.setModifiedDate(createdStore.getModifiedDate());
        return storeDto;
    }
}
