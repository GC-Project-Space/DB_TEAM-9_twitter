package com.example.twitterclone.domain.users.controller;

import com.example.twitterclone.domain.users.converter.UsersResponseConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.dto.UsersResponse;
import com.example.twitterclone.domain.users.service.UsersService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Users", description = "Users API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    /**
     * 회원가입
     *
     * @method POST
     * @url /users/sign-up
     * @param request: UsersRequest.SignUpUserDto
     * @return ApiResponse<UsersResponse.SignUpUserDto>
     */
    @PostMapping("/sign-up")
    public ApiResponse<UsersResponse.SignUpUserDto> signUp (
            @RequestBody @Valid UsersRequest.SignUpUserDto request
    ) {
        Users user = usersService.signUp(request);
        return ApiResponse.onSuccess(UsersResponseConverter.toSignUpDto(user));
    }

    /**
     * 로그인
     *
     * @method POST
     * @url /users/sign-in
     * @param request: UsersRequest.SignInUserDto
     * @return ApiResponse<UsersResponse.SignInUserDto>
     */
    @PostMapping("/sign-in")
    public ApiResponse<UsersResponse.SignInUserDto> signIn (
            @RequestBody @Valid UsersRequest.SignInUserDto request
    ) {
        Users user = usersService.signIn(request);
        return ApiResponse.onSuccess(UsersResponseConverter.toSignInDto(user));
    }

    /**
     * 비밀번호 변경
     *
     * @method PUT
     * @url /users/modify/password
     * @param request: UsersRequest.ChangePasswordUserDto
     * @return ApiResponse<UsersResponse.ChangePasswordUserDto>
     */
    @PutMapping("/modify/password")
    public ApiResponse<UsersResponse.ChangePasswordUserDto> changePassword (
            @RequestBody @Valid UsersRequest.ChangePasswordUserDto request
    ) {
        Users user = usersService.changePassword(request);
        return ApiResponse.onSuccess(UsersResponseConverter.toChangePasswordDto(user));
    }
}
