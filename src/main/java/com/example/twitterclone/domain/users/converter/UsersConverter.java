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
        Gender gender = Gender.fromString(request.getGender());

        String profileImage = request.getProfileImage().isBlank() ? "default.png" : request.getProfileImage();

        return Users.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .brith(request.getBrith())
                .nickname(request.getNickname())
                .phone(request.getPhone())
                .gender(gender)
                .profileImage(profileImage)
                .build();

    }

}
