package com.example.twitterclone.global.common.code.status;

import com.example.twitterclone.global.common.code.BaseErrorCode;
import com.example.twitterclone.global.common.response.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    /*
        ErrorCode는 다음과 같은 형식으로 작성합니다.

        1. Success 및 Common Error
            HTTP_STATUS: HTTP_STATUS 는 HttpStatus Enum 을 참고하여 작성합니다.
                ex) _OK, _BAD_REQUEST, _UNAUTHORIZED, _FORBIDDEN, _METHOD_NOT_ALLOWED, _INTERNAL_SERVER_ERROR
            CODE: [CATEGORY]_[HTTP_STATUS_CODE]
                ex) SUCCESS_200, COMMON_400, COMMON_401, COMMON_403, COMMON_405, COMMON_500

        2. Other Error
            HTTP_STATUS: 에러의 상황을 잘 들어내는 HttpStatus 를 작성합니다.
                ex) USER_NOT_FOUND, USER_ALREADY_EXISTS
            CODE: [CATEGORY]_[HTTP_STATUS_CODE]_[ERROR_CODE]의 형식으로 작성합니다.
                ex) BAD_REQUEST -> USER_400_001,
                    NOT_FOUND -> USER_404_001,
                    ALREADY_EXISTS -> USER_409_001
     */

    // Common Error & Global Error
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_401", "인증 과정에서 오류가 발생했습니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청입니다."),
    _METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON_405", "지원하지 않는 Http Method 입니다."),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 에러가 발생했습니다."),

    _METHOD_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, "METHOD_ARGUMENT_ERROR", "올바르지 않은 클라이언트 요청값입니다."), // controller 에서 받은 요청 DTO 유효성 검증

    // User Error
    PASSWORD_NOT_VALID(HttpStatus.BAD_REQUEST, "USER_400_001", "비밀번호는 영어/숫자/특수문자를 포함해야 하며, 8 ~ 20 글자여야 합니다."),
    NICKNAME_NOT_VALID(HttpStatus.BAD_REQUEST, "USER_400_002", "닉네임은 특수문자 없이 1 ~ 10 글자로 설정 해주세요."),
    PHONE_NUMBER_NOT_VALID(HttpStatus.BAD_REQUEST, "USER_400_003", "전화번호는 000-0000-0000의 형태로 입력해주세요."),
    BRITH_NOT_VALID(HttpStatus.BAD_REQUEST, "USER_400_004", "생년월일은 0000-00-00의 형태로 입력해주세요."),

    NICKNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "USER_409_001", "이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "USER_409_002", "이미 존재하는 이메일입니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ApiResponse.ErrorReasonDto getReason() {
        return ApiResponse.ErrorReasonDto.builder()
                .isSuccess(false)
                .code(this.code)
                .message(this.message)
                .build();
    }

    @Override
    public ApiResponse.ErrorReasonDto getReasonHttpStatus() {
        return ApiResponse.ErrorReasonDto.builder()
                .httpStatus(this.httpStatus)
                .isSuccess(false)
                .code(this.code)
                .message(this.message)
                .build();
    }
}
