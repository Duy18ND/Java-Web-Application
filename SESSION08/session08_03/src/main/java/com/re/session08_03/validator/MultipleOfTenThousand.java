package com.re.session08_03.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class) // Trỏ tới class chứa logic
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Áp dụng cho các biến (field)
@Retention(RetentionPolicy.RUNTIME) // Tồn tại khi chương trình đang chạy
public @interface MultipleOfTenThousand {

    // Câu thông báo lỗi mặc định
    String message() default "Số tiền rút phải là bội số của 10.000 VNĐ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}