package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.EmailExistValidator;
import com.example.twitterclone.domain.users.validation.validator.NickNameExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = EmailExistValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface EmailExist {

    String message() default "이미 존재하는 이메일입니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
