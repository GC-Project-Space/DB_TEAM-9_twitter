package com.example.twitterclone.domain.users.service;

import com.example.twitterclone.domain.users.converter.UsersConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.repository.UsersWriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersWriteRepository usersWriteRepository;

    public Users signUp(UsersRequest.SignUpUserDto request) {
        Users user = UsersConverter.toUsers(request);
        return usersWriteRepository.save(user);
    }
}
