package com.example.twitterclone.domain.users.validation.annotation;

import com.example.twitterclone.domain.users.validation.validator.NickNameExistValidator;
import com.example.twitterclone.domain.users.validation.validator.NickNameValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = NickNameExistValidator.class)
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface NickNameExist {

    String message() default "아무튼 사용중임 ㅋㅋ";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
