package com.example.twitterclone.domain.users.dto;

import com.example.twitterclone.domain.users.validation.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * UsersRequest
 *
 * 유저 요청 dto
 */
public class UsersRequest {

    /**
     * <Annotation 설명>
     * @Valid 어노테이션에 의해 검증이 필요한 객체에 붙여준다.
     *
     * [Spring Annotation] <- Spring에서 제공하는 Annotation
     * @Email : 이메일 형식이 올바른지 확인
     * @NotNull : null 값이 아닌지 확인
     *
     * [Custom Annotation] <- 직접 만든 Annotation
     * @EmailNotExist : 이메일이 존재 유무 확인 (존재하지 않아야 함)
     * @EmailExist : 이메일이 존재 유무 확인 (존재해야 함)
     * @PasswordValid : 비밀번호 형식이 올바른지 확인
     * @NickNameValid : 닉네임 형식이 올바른지 확인
     * @NickNameExist : 닉네임이 존재 유무 확인 (존재해야 함)
     * @PhoneValid : 전화번호 형식이 올바른지 확인
     * @BrithValid : 생년월일 형식이 올바른지 확인
     */

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUpUserDto {

        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @EmailNotExist
        @NotNull(message = "이메일을 입력해주세요.")
        private String email;

        @PasswordValid
        @NotNull(message = "비밀번호를 입력해주세요.")
        private String password;

        @NotNull(message = "이름을 입력해주세요.")
        private String name;

        @NickNameValid
        @NickNameExist
        @NotNull(message = "닉네임을 입력해주세요.")
        private String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignInUserDto {

        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @EmailExist
        @NotNull(message = "이메일을 입력해주세요.")
        private String email;

        @PasswordValid
        @NotNull(message = "비밀번호를 입력해주세요.")
        private String password;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChangePasswordUserDto {

        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @EmailExist
        @NotNull(message = "이메일을 입력해주세요.")
        private String email;

        @PasswordValid
        @NotNull(message = "비밀번호를 입력해주세요.")
        private String password;

        @PasswordValid
        @NotNull(message = "비밀번호를 입력해주세요.")
        private String newPassword;
    }
}
