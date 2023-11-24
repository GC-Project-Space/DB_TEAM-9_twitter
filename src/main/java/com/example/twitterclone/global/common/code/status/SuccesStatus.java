package com.example.twitterclone.global.common.code.status;

import com.example.twitterclone.global.common.code.BaseCode;
import com.example.twitterclone.global.common.code.BaseErrorCode;
import com.example.twitterclone.global.common.response.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccesStatus implements BaseCode {

    // Success
    _OK(HttpStatus.OK, "SUCCESS_200", "OK"),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ApiResponse.ReasonDto getReason() {
        return ApiResponse.ReasonDto.builder()
                .isSuccess(true)
                .code(this.code)
                .message(this.message)
                .build();
    }

    @Override
    public ApiResponse.ReasonDto getReasonHttpStatus() {
        return ApiResponse.ReasonDto.builder()
                .httpStatus(this.httpStatus)
                .isSuccess(true)
                .code(this.code)
                .message(this.message)
                .build();
    }
}
