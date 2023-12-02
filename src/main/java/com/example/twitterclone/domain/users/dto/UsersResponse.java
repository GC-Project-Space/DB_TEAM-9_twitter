package com.example.twitterclone.domain.users.dto;

import lombok.Builder;
import lombok.Getter;

public class UsersResponse {

    @Getter
    @Builder
    public static class SignUpUserDto {
        String message;
    }

    @Getter
    @Builder
    public static class SignInUserDto {
        Long userId;
        String message;
    }

    @Getter
    @Builder
    public static class ChangePasswordUserDto {
        String message;
    }

    @Getter
    @Builder
    public static class UserProfileDto {
        private Long id;
        private String name;
        private String nickname;
        private String profileImage;
        private String coverImage;
        private String bio;
        private String birth;
    }
}
