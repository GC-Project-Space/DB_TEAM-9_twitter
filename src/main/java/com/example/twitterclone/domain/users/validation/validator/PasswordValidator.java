package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.validation.annotation.PasswordValid;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

    @Override
    public void initialize(PasswordValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isPassword = value.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$");

        if(!isPassword) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PASSWORD_NOT_VALID.getMessage())
                    .addConstraintViolation();
        }

        return isPassword;
    }
}
