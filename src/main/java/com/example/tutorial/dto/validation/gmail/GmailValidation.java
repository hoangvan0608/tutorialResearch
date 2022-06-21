package com.example.tutorial.dto.validation.gmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GmailValidation implements ConstraintValidator<GmailAnnotation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("@gmail.com") || value.equals("@gmail.com.vn");
    }
}
