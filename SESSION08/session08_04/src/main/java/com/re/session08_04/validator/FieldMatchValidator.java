package com.re.session08_04.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            // Lấy giá trị của 2 trường từ Object truyền vào
            final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
            final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);

            // 1. Cả 2 đều null -> Trả về true (Bỏ qua để các thẻ @NotNull của từng field tự báo lỗi)
            // 2. Một trong 2 cái null -> Chắc chắn không khớp -> Trả về false
            // 3. Cả 2 đều có giá trị -> Gọi hàm equals() một cách an toàn
            boolean isValid = (firstObj == null && secondObj == null) ||
                    (firstObj != null && firstObj.equals(secondObj));

            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message)
                        .addPropertyNode(secondFieldName) // Đẩy lỗi vào trường confirmPassword
                        .addConstraintViolation();
            }

            return isValid;
        } catch (final Exception ignore) {
            // Đề phòng truyền sai tên biến, không tìm thấy property
            return false;
        }
    }
}