package com.example.twitterclone.domain.users.service;

import com.example.twitterclone.domain.users.converter.UsersConverter;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.dto.AuthResponse;
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
public class AuthService {
    private final UsersReadRepository usersReadRepository;

    @Transactional
    public Users getUserInfo(String email) {
        return usersReadRepository.findByEmail(email);
    }
}
