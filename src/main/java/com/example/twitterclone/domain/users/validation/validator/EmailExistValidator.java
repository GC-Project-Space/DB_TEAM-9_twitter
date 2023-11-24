package com.example.twitterclone.domain.users.validation.validator;

import com.example.twitterclone.domain.users.repository.UsersValidRepository;
import com.example.twitterclone.domain.users.validation.annotation.EmailExist;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class EmailExistValidator implements ConstraintValidator<EmailExist, String> {

    private final UsersValidRepository usersValidRepository;

    @Override
    public void initialize(EmailExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isExistEmail = this.usersValidRepository.existsByEmail(value);

        if (isExistEmail) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.EMAIL_ALREADY_EXISTS.getMessage())
                    .addConstraintViolation();
        }

        return !isExistEmail;
    }
}
