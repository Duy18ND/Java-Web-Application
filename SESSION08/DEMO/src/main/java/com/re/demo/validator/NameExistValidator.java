package com.re.demo.validator;

import com.re.demo.controller.PersonController;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameExistValidator implements ConstraintValidator<NameExists, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExist = PersonController.personList.stream().anyMatch(p -> p.getName().equals(s));
        return !isExist;
    }
}
