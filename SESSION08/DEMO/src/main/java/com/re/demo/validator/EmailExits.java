package com.re.demo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

// 1. @Documented:
// Khi code của bạn được xuất ra thành tài liệu JavaDoc (giống như từ điển code),
// nó sẽ mang theo cả thông tin của cái Annotation này để các lập trình viên khác đọc hiểu.
@Documented

// 2. @Constraint:
// Cực kỳ quan trọng! Nó bảo Spring rằng: "Cái mác này dùng để kiểm tra dữ liệu nhé.
// Và bộ não xử lý logic cho cái mác này nằm ở class EmailExistValidator.class".
@Constraint(validatedBy = EmailExistValidator.class)

// 3. @Retention(RetentionPolicy.RUNTIME):
// Annotation có 3 vòng đời (Mã nguồn -> Biên dịch -> Chạy).
// Lệnh RUNTIME ép hệ thống phải giữ cái mác này sống sót đến tận lúc chương trình đang chạy,
// để Spring có thể "soi" thấy nó và kích hoạt kiểm tra.
@Retention(RetentionPolicy.RUNTIME)

// 4. @Target:
// Quy định chỗ được phép dán cái mác này.
// ElementType.FIELD: Được dán lên các biến (ví dụ: private String email).
// ElementType.METHOD: Được dán lên các hàm.
@Target({ElementType.FIELD, ElementType.METHOD})

// 5. @interface: Từ khóa để khai báo đây là một Annotation, không phải là Class hay Interface bình thường.
public @interface EmailExits {

    // --- ⚠️ 3 THUỘC TÍNH BẮT BUỘC PHẢI THÊM ĐỂ KHÔNG BỊ LỖI ---

    // Thuộc tính 1: Thông báo lỗi mặc định nếu người dùng gõ trùng Email.
    String message() default "Email đã tồn tại trong hệ thống!";

    // Thuộc tính 2: Dùng để phân nhóm các quy tắc kiểm tra (thường để trống theo chuẩn của Jakarta).
    Class<?>[] groups() default {};

    // Thuộc tính 3: Dùng để đính kèm thêm dữ liệu phụ trợ khi có lỗi xảy ra (thường để trống).
    Class<? extends Payload>[] payload() default {};
}