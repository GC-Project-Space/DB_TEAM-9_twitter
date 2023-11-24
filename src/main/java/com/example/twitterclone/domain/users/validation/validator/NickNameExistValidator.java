package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.repository.UsersValidRepository;
import com.example.twitterclone.domain.users.validation.annotation.NickNameExist;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class NickNameExistValidator implements ConstraintValidator<NickNameExist, String> {

    private final UsersValidRepository usersValidRepository;

    @Override
    public void initialize(NickNameExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isExistNickName = this.usersValidRepository.existsByNickname(value);

        if(isExistNickName) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.NICKNAME_ALREADY_EXISTS.getMessage())
                    .addConstraintViolation();
        }

        return !isExistNickName;
    }
}
