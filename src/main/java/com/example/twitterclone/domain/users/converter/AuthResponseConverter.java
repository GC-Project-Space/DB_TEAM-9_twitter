package com.example.twitterclone.domain.users.converter;

import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.AuthResponse;

/**
 * UsersResponseConverter
 *
 * 유저 응답 entity 변환 클래스
 */
public class AuthResponseConverter {

    public static AuthResponse.GetUserInfoDto toGetUserInfoDto(Users user) {
        return AuthResponse.GetUserInfoDto.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
