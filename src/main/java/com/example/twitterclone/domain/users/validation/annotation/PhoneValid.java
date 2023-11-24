package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.PhoneValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface PhoneValid {

    String message() default "전화번호는 000-0000-0000의 형태로 입력해주세요.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
