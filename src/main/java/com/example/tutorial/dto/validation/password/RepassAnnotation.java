package com.example.tutorial.dto.validation.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RepassValidation.class)
@Target( {ElementType.TYPE } )
@Retention(RetentionPolicy.RUNTIME)
public @interface RepassAnnotation {
    //error message
    public String message() default "Mật khẩu không trùng khớp";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
