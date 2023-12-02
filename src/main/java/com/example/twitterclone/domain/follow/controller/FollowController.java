package com.example.twitterclone.domain.follow.controller;

import com.example.twitterclone.domain.follow.converter.FollowConverter;
import com.example.twitterclone.domain.follow.domain.Follow;
import com.example.twitterclone.domain.follow.dto.FollowRequest;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import com.example.twitterclone.domain.follow.service.FollowService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    /**
     * 팔로우
     *
     * @method POST
     * @url /follows/following
     * @param request: FollowRequest.FollowDto
     * @return ApiResponse<FollowResponse.FollowRes>
     */
    @Operation(summary = "팔로우", description = "팔로우 API")
    @PostMapping("/following")
    public ApiResponse<FollowResponse.FollowRes> follow(
            @RequestBody FollowRequest.FollowDto request // FollowRequest.FollowDto
    ) {
        Follow follow = followService.follow(request);
        return ApiResponse.onSuccess(FollowConverter.toFollowRes());
    }

    /**
     * 언팔로우
     *
     * @method POST
     * @url /follows/unFollow
     * @param request: FollowRequest.UnFollowDto
     * @return ApiResponse<FollowResponse.UnFollowRes>
     */
    @Operation(summary = "언팔로우", description = "언팔로우 API")
    @PostMapping("/unFollow")
    public ApiResponse<FollowResponse.UnFollowRes> unfollow(
            @RequestBody FollowRequest.UnFollowDto request
    ) {
        followService.unfollow(request);
        return ApiResponse.onSuccess(FollowConverter.toUnFollow());
    }

    /**
     * 팔로워, 팔로잉 수
     *
     * @method GET
     * @url /follows/is-follow
     * @param email: String
     * @param email: String
     * @return ApiResponse<FollowResponse.IsFollowRes>
     */
    @Operation(summary = "팔로워, 팔로잉 수", description = "팔로워, 팔로잉 수 API")
    @GetMapping("/count")
    public ApiResponse<FollowResponse.CountRes> count(
            @RequestParam(name = "email") String email
    ) {
        return ApiResponse.onSuccess(followService.followCount(email));
    }


}