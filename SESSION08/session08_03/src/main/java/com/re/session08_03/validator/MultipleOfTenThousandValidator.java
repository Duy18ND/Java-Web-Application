package com.re.session08_03.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator implements ConstraintValidator<MultipleOfTenThousand, Long> {

    @Override
    public void initialize(MultipleOfTenThousand constraintAnnotation) {
        // Khởi tạo nếu cần (thường để trống)
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // 1. Xử lý bẫy NULL (Best Practice)
        if (value == null) {
            return true; // Bỏ qua, để @NotNull lo việc này
        }

        // 2. Logic nghiệp vụ cốt lõi: Chia lấy dư cho 10.000
        return value % 10000 == 0;
    }
}