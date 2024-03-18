package sodong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sodong.domain.Store;
import sodong.domain.StoreForm;
import sodong.domain.StoreResponseDto;
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
    public Optional<Store> getStore(@RequestParam Long storeId){
        return storeService.findOne(storeId);
    }
    @GetMapping("/all")
    public List<Store> list(){return storeService.findStores();}
    @PostMapping
    public StoreResponseDto create(@RequestBody StoreForm storeForm){
        Store store = new Store();
        store.setUserId(storeForm.getUserId());
        store.setAddress(storeForm.getAddress());
        store.setName(storeForm.getName());
        store.setOperationHours(storeForm.getOperationHours());

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
