package com.unibuc.beautysalon.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositivePriceValidator.class)
public @interface PositivePrice {

    String message() default "Price must be positive.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}