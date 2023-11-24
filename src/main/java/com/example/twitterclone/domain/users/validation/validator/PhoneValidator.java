package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.validation.annotation.PhoneValid;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PhoneValidator implements ConstraintValidator<PhoneValid, String> {

    @Override
    public void initialize(PhoneValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isPhone = value.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");

        if(!isPhone) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PHONE_NUMBER_NOT_VALID.getMessage())
                    .addConstraintViolation();
        }

        return isPhone;
    }
}
