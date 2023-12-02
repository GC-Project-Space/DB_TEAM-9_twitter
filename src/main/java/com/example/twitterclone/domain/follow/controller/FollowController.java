package com.example.twitterclone.domain.follow.controller;

import com.example.twitterclone.domain.follow.converter.FollowConverter;
import com.example.twitterclone.domain.follow.domain.Follow;
import com.example.twitterclone.domain.follow.dto.FollowRequest;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.follow.service.FollowService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Follows", description = "Follow API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/follows")
public class FollowController {

    private final FollowService followService;

    // REST API
    // GET(조회) | POST(생성), PUT(수정) - request body (o)

    // 팔로우
    @PostMapping("/following")
    public ApiResponse<FollowResponse.FollowRes> follow(
            @RequestBody FollowRequest.FollowDto request // FollowRequest.FollowDto
    ) {
        Follow follow = followService.follow(request);
        return ApiResponse.onSuccess(FollowConverter.toFollowRes());
    }

    // 언팔로우
    @PostMapping("/unFollow")
    public ApiResponse<FollowResponse.UnFollowRes> unfollow(
            @RequestBody FollowRequest.UnFollowDto request
    ) {
        followService.unfollow(request);
        return ApiResponse.onSuccess(FollowConverter.toUnFollow());
    }

    // 팔로잉, 팔로워 수 조회
    @GetMapping("/count")
    public ApiResponse<FollowResponse.CountRes> count(
            @RequestParam(name = "email") String email
    ) {
        return ApiResponse.onSuccess(followService.followCount(email));
    }
}