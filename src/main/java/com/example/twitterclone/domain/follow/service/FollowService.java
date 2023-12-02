package com.example.twitterclone.domain.follow.service;

import com.example.twitterclone.domain.follow.converter.FollowConverter;
import com.example.twitterclone.domain.follow.domain.Follow;
import com.example.twitterclone.domain.follow.dto.FollowRequest;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.follow.repository.FollowRepository;
import com.example.twitterclone.domain.users.domain.Users;
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
    public Follow follow(
            FollowRequest.FollowDto request
    ) {
        // FollowRequest에서 필요한 정보를 추출
        Users toUsers = usersReadRepository.findById(request.getFollowerId()).orElseThrow();
        Users fromUsers = usersReadRepository.findById(request.getFollowingId()).orElseThrow();

        Follow follow = FollowConverter.toFollow(toUsers, fromUsers);
        // 팔로우에 성공했다면, 팔로우 결과를 FollowResponse에 담아 반환
        return followRepository.save(follow);
    }

    @Transactional
    public void unfollow(
            FollowRequest.UnFollowDto request
    ) {
        // FollowRequest에서 필요한 정보를 추출
        Users toUsers = usersReadRepository.findById(request.getFollowerId()).orElseThrow();
        Users fromUsers = usersReadRepository.findById(request.getFollowingId()).orElseThrow();

        Follow follow = FollowConverter.toUnFollow(toUsers, fromUsers);
        // 언팔로우에 성공했다면, 언팔로우 결과를 FollowResponse에 담아 반환
        followRepository.delete(follow);
    }
}