package com.example.twitterclone.domain.follow.controller;

import com.example.twitterclone.domain.follow.dto.FollowRequest;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.follow.service.FollowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Follows", description = "Follow API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/follows")
public class FollowController {

    private final FollowService followService;

    // 팔로우
    @PostMapping("/{followerId}/follow/{followingId}")
    public ResponseEntity<FollowResponse> follow(@PathVariable Long followerId, @PathVariable Long followingId) {
        FollowRequest followRequest = new FollowRequest(followerId, followingId);
        FollowResponse response = followService.follow(followRequest);
        return ResponseEntity.ok(response);
    }

    // 언팔로우
    @PostMapping("/{followerId}/unfollow/{followingId}")
    public ResponseEntity<FollowResponse> unfollow(@PathVariable Long followerId, @PathVariable Long followingId) {
        FollowRequest unfollowRequest = new FollowRequest(followerId, followingId);
        FollowResponse response = followService.unfollow(unfollowRequest);
        return ResponseEntity.ok(response);
    }
}