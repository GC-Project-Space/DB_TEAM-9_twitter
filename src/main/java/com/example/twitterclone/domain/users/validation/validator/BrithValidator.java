package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.validation.annotation.BrithValid;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class BrithValidator implements ConstraintValidator<BrithValid, String> {
    @Override
    public void initialize(BrithValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isBrith = value.matches("^\\d{4}-\\d{2}-\\d{2}$");

        if (!isBrith) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.BRITH_NOT_VALID.getMessage())
                    .addConstraintViolation();
        }

        return isBrith;
    }
}
