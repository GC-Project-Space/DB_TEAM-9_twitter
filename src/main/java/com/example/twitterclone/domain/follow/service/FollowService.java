package com.example.twitterclone.domain.follow.service;

import com.example.twitterclone.domain.follow.dto.FollowRequest;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.follow.repository.FollowRepository;
import com.example.twitterclone.domain.users.repository.UsersReadRepository;
import com.example.twitterclone.domain.users.repository.UsersWriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UsersReadRepository usersReadRepository;
    private final UsersWriteRepository usersWriteRepository;

    @Transactional
    public FollowResponse follow(FollowRequest followRequest) {
        // FollowRequest에서 필요한 정보를 추출하고, 팔로우 관련 비즈니스 로직을 수행합니다.
        // ...

        // 팔로우에 성공했다면, 팔로우 결과를 FollowResponse에 담아 반환합니다.
        return new FollowResponse("success", "팔로우에 성공했습니다.");
    }

    @Transactional
    public FollowResponse unfollow(FollowRequest followRequest) {
        // FollowRequest에서 필요한 정보를 추출하고, 언팔로우 관련 비즈니스 로직을 수행합니다.
        // ...

        // 언팔로우에 성공했다면, 언팔로우 결과를 FollowResponse에 담아 반환합니다.
        return new FollowResponse("success", "언팔로우에 성공했습니다.");
    }
}