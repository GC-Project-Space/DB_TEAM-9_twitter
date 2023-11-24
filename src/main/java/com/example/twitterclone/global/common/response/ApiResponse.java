package com.example.twitterclone.global.common.response;

import com.example.twitterclone.global.common.code.BaseCode;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import com.example.twitterclone.global.common.code.status.SuccesStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T>{

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;

    // 성공한 경우
    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccesStatus._OK.getCode(), SuccesStatus._OK.getMessage(), result);
    }
    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }
    
    // 실패한 경우
    public static <T> ApiResponse<T> onFailure(String code, String message, T result){
        return new ApiResponse<>(false, code, message, result);
    }

    @Getter
    @Builder
    public static class ErrorReasonDto {
        private HttpStatus httpStatus;
        private final boolean isSuccess;
        private final String code;
        private final String message;
    }

    @Getter
    @Builder
    public static class ReasonDto {
        private HttpStatus httpStatus;
        private final boolean isSuccess;
        private final String code;
        private final String message;
    }
}
