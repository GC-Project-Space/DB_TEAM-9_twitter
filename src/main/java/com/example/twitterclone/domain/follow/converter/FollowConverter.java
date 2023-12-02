package com.example.twitterclone.domain.follow.converter;

import com.example.twitterclone.domain.follow.domain.Follow;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.users.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

public class FollowConverter {

    public static Follow toFollow(Users toUser, Users fromUser) {
        return Follow.builder()
                .from_user(fromUser)
                .to_user(toUser)
                .build();
    }

    public static Follow toUnFollow(Users toUser, Users fromUser) {
        return Follow.builder()
                .id(toUser.getId())
                .from_user(fromUser)
                .to_user(toUser)
                .build();
    }

    public static FollowResponse.FollowRes toFollowRes() {
        return FollowResponse.FollowRes.builder()
                .message("팔로우 성공!")
                .build();
    }

    public static FollowResponse.UnFollowRes toUnFollow() {
        return FollowResponse.UnFollowRes.builder()
                .message("언팔로우 성공!")
                .build();
    }

    public static List<FollowResponse.FollowDto> toFollowDtoList(List<Follow> followers) {
        return followers.stream()
                .map(follower -> FollowResponse.FollowDto.builder()
                        .id(follower.getFrom_user().getId())
                        .name(follower.getFrom_user().getName())
                        .nickname(follower.getFrom_user().getNickname())
                        .profileImage(follower.getFrom_user().getProfileImage())
                        .build())
                .collect(Collectors.toList());
    }
}

