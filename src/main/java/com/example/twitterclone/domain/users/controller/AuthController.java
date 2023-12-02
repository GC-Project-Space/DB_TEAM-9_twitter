package com.example.twitterclone.domain.users.controller;

import com.example.twitterclone.domain.users.converter.AuthResponseConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.AuthResponse;
import com.example.twitterclone.domain.users.service.AuthService;
import com.example.twitterclone.domain.users.validation.annotation.EmailExist;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@Tag(name = "Auth", description = "인증 API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/user-info")
    public ApiResponse<AuthResponse.GetUserInfoDto> getUserInfo(
            @RequestParam(name = "email") @Email @EmailExist String email
    ) {
        Users user = authService.getUserInfo(email);
        return ApiResponse.onSuccess(AuthResponseConverter.toGetUserInfoDto(user));
    }

}
