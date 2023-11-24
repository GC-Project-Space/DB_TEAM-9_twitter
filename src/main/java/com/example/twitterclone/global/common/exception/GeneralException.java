package com.example.twitterclone.global.common.exception;

import com.example.twitterclone.global.common.code.BaseErrorCode;
import com.example.twitterclone.global.common.response.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

    public ApiResponse.ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ApiResponse.ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
