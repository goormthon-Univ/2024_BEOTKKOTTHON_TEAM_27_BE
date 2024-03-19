package sodong.domain.response.dto;

public record StoreResponseDto (
        Long userId,
        Long storeId,
        String name,
        String address
) {
}
