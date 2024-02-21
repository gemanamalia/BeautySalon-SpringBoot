package com.unibuc.beautysalon.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidator.class)
public @interface ValidRating {
    String message() default "Rating must be an integer between 1 and 5.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
