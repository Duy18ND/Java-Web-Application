package com.re.session08_01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDto {
    /*
    1. Lỗi khoảng trắng -> Sử dụng @NotNull là cách rỗng nhập khoảng trắng rồi enter vẫn tính là 1 ký tự
    Thiếu @Valid  validation không chạy → Postman phá backend
    Không handle lỗi → ném exception → 500
    */

//    @NotNull(message = "Tên người dùng không được để trống!")
    @NotBlank(message = "Tên người dùng không được để trống!")
    private String receiverName;

//    @NotNull(message = "Địa chỉ không được để trống!")
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String detailAddress;

    //Getter setter
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
