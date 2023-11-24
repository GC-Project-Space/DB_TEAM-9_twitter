package com.example.twitterclone.domain.users.service;

import com.example.twitterclone.domain.users.converter.UsersConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.repository.UsersReadRepository;
import com.example.twitterclone.domain.users.repository.UsersWriteRepository;
import com.example.twitterclone.domain.users.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for Users
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersWriteRepository usersWriteRepository;
    private final UsersReadRepository usersReadRepository;

    private final PasswordUtil passwordUtil;

    @Transactional
    public Users signUp(UsersRequest.SignUpUserDto request) {
        Users user = UsersConverter.toUsers(request);
        return usersWriteRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Users signIn(UsersRequest.SignInUserDto request) {
        Users user = usersReadRepository.findByEmail(request.getEmail());
        return user;
    }

    @Transactional
    public Users changePassword(UsersRequest.ChangePasswordUserDto request) {
        Users user = usersReadRepository.findByEmail(request.getEmail());
        passwordUtil.isChangeable(user.getPassword(), request.getNewPassword());
        user.changePassword(request.getNewPassword());
        return usersWriteRepository.save(user);
    }
}
