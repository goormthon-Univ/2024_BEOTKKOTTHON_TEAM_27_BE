package sodong.domain.request.dto;


public record StoreRequestDto(
        Long userId,
        String name,
        String address
) {
}
