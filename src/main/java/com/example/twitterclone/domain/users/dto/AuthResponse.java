package com.example.twitterclone.domain.users.dto;

import lombok.Builder;
import lombok.Getter;

public class AuthResponse {

    @Getter
    @Builder
    public static class GetUserInfoDto {
        Long userId;
        String email;
        String password;
    }
}
