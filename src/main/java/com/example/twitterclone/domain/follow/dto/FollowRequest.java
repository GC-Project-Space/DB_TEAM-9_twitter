package com.example.twitterclone.domain.follow.dto;

public class FollowRequest {

    private Long followerId;
    private Long followingId;

    // 생성자, 게터, 세터 등을 추가할 수 있습니다.

    public FollowRequest() {
        // 기본 생성자
    }

    public FollowRequest(Long followerId, Long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }
}
