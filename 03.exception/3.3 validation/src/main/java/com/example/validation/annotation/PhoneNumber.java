package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.constraints.ConstraintComposition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ElementType.FIELD}) // only applied to fields (member variables of a clasS)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    //variable name message is hardcoded
    String message() default "does not match phone number format";
    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
