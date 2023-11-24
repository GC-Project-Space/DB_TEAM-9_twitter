package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.BrithValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BrithValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface BrithValid {

    String message() default "생년월일은 0000-00-00의 형태로 입력해주세요.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
