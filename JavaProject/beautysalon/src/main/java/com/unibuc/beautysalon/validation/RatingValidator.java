package com.unibuc.beautysalon.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<ValidRating, Integer> {
    @Override
    public void initialize(ValidRating constraint) {
    }

    @Override
    public boolean isValid(Integer rating, ConstraintValidatorContext context) {
        return rating != null && rating >= 1 && rating <= 5;
    }
}
