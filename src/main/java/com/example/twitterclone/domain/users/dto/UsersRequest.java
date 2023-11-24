package com.example.twitterclone.domain.users.dto;

import com.example.twitterclone.domain.users.validation.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UsersRequest {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUpUserDto {

        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @EmailExist
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

        @PhoneValid
        @NotNull(message = "전화번호를 입력해주세요.")
        private String phone;

        private String gender;

        @BrithValid
        private String brith;

        private String profileImage;
    }

}
