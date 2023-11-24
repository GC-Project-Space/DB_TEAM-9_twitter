package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.PasswordValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface PasswordValid {

    String message() default "비밀번호는 영어/숫자/특수문자를 포함해야하며, 8 ~ 20 글자로 설정해주세요.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
