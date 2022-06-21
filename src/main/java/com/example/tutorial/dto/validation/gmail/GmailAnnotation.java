package com.example.tutorial.dto.validation.gmail;

import com.example.tutorial.dto.validation.password.RepassValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GmailValidation.class)
@Target( {ElementType.FIELD, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface GmailAnnotation {
    //error message
    public String message() default "Vui lòng nhập đúng định dạng gmail";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
