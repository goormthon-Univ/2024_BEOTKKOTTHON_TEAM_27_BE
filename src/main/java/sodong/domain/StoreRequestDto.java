package sodong.domain;

public class StoreRequestDto {
    private Long userId;
    private String name;
    private String address;
    private String phone;
    private String operationHours;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
}
