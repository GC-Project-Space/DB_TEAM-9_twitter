package com.example.twitterclone.domain.follow.dto;

public class FollowResponse {

    private String status;
    private String message;

    // 생성자, 게터, 세터 등을 추가할 수 있습니다.

    public FollowResponse() {
        // 기본 생성자
    }

    public FollowResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}