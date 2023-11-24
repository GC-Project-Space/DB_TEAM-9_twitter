package com.example.twitterclone.domain.users.controller;

import com.example.twitterclone.domain.users.converter.UsersConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.dto.UsersResponse;
import com.example.twitterclone.domain.users.service.UsersService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Users", description = "Users API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/sign-up")
    public ApiResponse<UsersResponse.SignUpUserDto> signUp (
            @RequestBody @Valid UsersRequest.SignUpUserDto request
    ) {
        Users user = usersService.signUp(request);
        return ApiResponse.onSuccess(UsersConverter.toSignUpDto(user));
    }
}
