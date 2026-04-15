package com.re.demo.validator;

import com.re.demo.controller.PersonController;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// 1. implements ConstraintValidator<EmailExits, String>:
// Ép class này tuân theo khuôn mẫu chuẩn của Spring.
// Tham số 1 (EmailExits): Khai báo class này sinh ra là để phục vụ cho cái thẻ @EmailExits.
// Tham số 2 (String): Khai báo kiểu dữ liệu mà nó sẽ nhận vào để kiểm tra (ở đây Email là dạng chuỗi String).
public class EmailExistValidator implements ConstraintValidator<EmailExits, String> {

    // 2. Hàm isValid: Trái tim của class. Nó sẽ được Spring tự động gọi tới khi cần kiểm tra.
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        // s: Chính là cái chữ (email) mà người dùng gõ vào form nhập liệu.
        // constraintValidatorContext: Cung cấp các công cụ để bạn có thể tùy chỉnh thông báo lỗi động (hiện tại chưa cần dùng tới).

        // 3. Logic kiểm tra nghiệp vụ:
        // Lấy danh sách personList ra, dùng Stream duyệt qua từng người (p).
        // anyMatch: Có bất kỳ người nào (p) có email giống hệt với email gõ vào (s) không?
        // - Nếu có ai trùng -> isExist = true
        // - Nếu không ai trùng -> isExist = false
        boolean isExist = PersonController.personList.stream().anyMatch(p -> p.getEmail().equals(s));

        // 4. Trả về kết quả cho Spring:
        // Spring quy định: return TRUE là HỢP LỆ (cho qua), return FALSE là LỖI (chặn lại).
        // - Nếu isExist = true (đã có người dùng email này) -> !isExist = false -> Bị chặn lại, quăng ra lỗi.
        // - Nếu isExist = false (chưa có ai dùng) -> !isExist = true -> Hợp lệ, cho phép lưu!
        return !isExist;
    }
}