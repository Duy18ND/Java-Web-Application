package com.re.session08_04.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // CHÚ Ý: Gắn lên Class (TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {

    String message() default "Hai trường dữ liệu không khớp nhau!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // Khai báo 2 thuộc tính để truyền tên 2 trường cần so sánh
    String first();
    String second();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}