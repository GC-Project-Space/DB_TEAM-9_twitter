package com.example.twitterclone.global.common.code;

import com.example.twitterclone.global.common.response.ApiResponse;

public interface BaseCode {

    public ApiResponse.ReasonDto getReason();

    public ApiResponse.ReasonDto getReasonHttpStatus();
}
