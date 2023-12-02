package com.example.twitterclone.domain.users.converter;

import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.domain.Gender;

/**
 * UsersConverter
 *
 * 유저 entity 변환 클래스
 */
public class UsersConverter {

    public static Users toUsers(UsersRequest.SignUpUserDto request) {

        return Users.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();

    }

}
