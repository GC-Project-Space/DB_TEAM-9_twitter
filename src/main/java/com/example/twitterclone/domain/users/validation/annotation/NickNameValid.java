package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.NickNameValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = NickNameValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface NickNameValid {

    String message() default "닉네임은 특수문자 없이 1 ~ 10 글자로 설정해주세요.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
