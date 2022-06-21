package com.example.tutorial.dto.validation.password;

import com.example.tutorial.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RepassValidation implements ConstraintValidator<RepassAnnotation, UserDTO> {
    @Override
    public boolean isValid(UserDTO value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getRepass());
    }
}
