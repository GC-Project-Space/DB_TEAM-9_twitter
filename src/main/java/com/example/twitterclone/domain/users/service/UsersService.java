package com.example.twitterclone.domain.users.service;

import com.example.twitterclone.domain.users.converter.UsersConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.repository.UsersReadRepository;
import com.example.twitterclone.domain.users.repository.UsersWriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for Users
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersWriteRepository usersWriteRepository;
    private final UsersReadRepository usersReadRepository;

    public Users signUp(UsersRequest.SignUpUserDto request) {
        Users user = UsersConverter.toUsers(request);
        return usersWriteRepository.save(user);
    }

    public Users signIn(UsersRequest.SignInUserDto request) {
        Users user = usersReadRepository.findByEmail(request.getEmail());
        return user;
    }
}
