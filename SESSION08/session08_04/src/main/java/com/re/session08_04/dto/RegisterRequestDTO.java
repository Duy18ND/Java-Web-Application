package com.re.session08_04.dto;

import com.re.session08_04.validator.FieldMatch;
import jakarta.validation.constraints.NotBlank;
/*
Phần 1:
    Input: Tham số DTO gửi lên từ client bao gồm username, password, và confirmPassword.
    Output: * Hợp lệ (True): password giống hệt confirmPassword ➔ Cho phép lưu User mới.
    Không hợp lệ (False): Khác nhau hoặc dính bẫy Null ➔ Trả về lỗi 400 Bad Request kèm thông báo "Mật khẩu xác nhận không khớp".
Phần 2:
Giải pháp 1: Dùng if-else trong Controller
    Boilerplate Code -> Nhiều lần
    Khả năng tái sử dụng -> Không có Fix cứng
    Separation of Concerns (SoC) -> Vi phạm nghiêm trọng

Giải pháp 2: Custom Annotation @FieldMatch (Class-level)
    Boilerplate Code -> Ít chỉ viết 1 lần
    Khả năng tái sử dụng -> Tuyệt đối.
    Separation of Concerns (SoC) -> Tuân thủ chuẩn Clean Code. Tách biệt hoàn toàn logic kiểm tra dữ liệu (Validation) ra khỏi luồng nghiệp vụ (Controller).
*/
@FieldMatch(first = "password", second = "confirmPassword", message = "Mật khẩu xác nhận không trùng khớp!")
public class RegisterRequestDTO {

    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    @NotBlank(message = "Vui lòng nhập lại mật khẩu")
    private String confirmPassword;
}