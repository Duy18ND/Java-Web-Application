package com.re.demo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface NameExists {
    String message() default "Name đã tồn tại trong hệ thống!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
