package com.example.twitterclone.global.common.code;

import com.example.twitterclone.global.common.response.ApiResponse;

public interface BaseErrorCode {

    public ApiResponse.ErrorReasonDto getReason();

    public ApiResponse.ErrorReasonDto getReasonHttpStatus();
}
