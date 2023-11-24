package com.example.twitterclone.domain.users.converter;

import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.dto.UsersResponse;
import com.example.twitterclone.domain.users.util.Gender;

public class UsersResponseConverter {

    public static UsersResponse.SignUpUserDto toSignUpDto(Users user) {
        return UsersResponse.SignUpUserDto.builder()
                .message(user.getNickname() + "님 회원가입을 축하드립니다.")
                .build();
    }

    public static UsersResponse.SignInUserDto toSignInDto(Users user) {
        return UsersResponse.SignInUserDto.builder()
                .userId(user.getId())
                .message(user.getNickname() + "님 로그인을 축하드립니다.")
                .build();
    }
}