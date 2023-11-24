package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.validation.annotation.NickNameValid;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class NickNameValidator implements ConstraintValidator<NickNameValid, String> {

    @Override
    public void initialize(NickNameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isNickName = value.matches("^[a-zA-Z0-9ㄱ-ㅎ가-힣]{2,10}$");

        if(!isNickName) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.NICKNAME_NOT_VALID.getMessage())
                    .addConstraintViolation();
        }

        return isNickName;
    }
}
