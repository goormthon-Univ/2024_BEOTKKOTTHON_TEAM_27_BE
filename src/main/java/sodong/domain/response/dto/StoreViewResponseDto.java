package sodong.domain.response.dto;

import java.time.LocalDateTime;
import java.util.List;

public class StoreViewResponseDto {
    private boolean isSuccess;
    private int code;
    private String message;
    private List<StoreDto> result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StoreDto> getResult() {
        return result;
    }

    public void setResult(List<StoreDto> result) {
        this.result = result;
    }

    public static class StoreDto {
        private long storeId;
        private long userId;
        private String name;
        private String address;
        private String phone;
        private String operationHours;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public long getStoreId() {
            return storeId;
        }

        public void setStoreId(long storeId) {
            this.storeId = storeId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getOperationHours() {
            return operationHours;
        }

        public void setOperationHours(String operationHours) {
            this.operationHours = operationHours;
        }

        public LocalDateTime getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
        }

        public LocalDateTime getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(LocalDateTime modifiedDate) {
            this.modifiedDate = modifiedDate;
        }
    }

}


