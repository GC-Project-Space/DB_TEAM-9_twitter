package com.example.twitterclone.domain.users.dto;

import lombok.Builder;
import lombok.Getter;

public class UsersResponse {

    @Getter
    @Builder
    public static class SignUpUserDto {
        String message;
    }
}
