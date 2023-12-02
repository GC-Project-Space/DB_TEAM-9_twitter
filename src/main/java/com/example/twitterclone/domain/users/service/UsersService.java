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

    /**
     * 회원가입
     *
     * @param request: UsersRequest.SignUpUserDto
     * @return Users
     */
    @Transactional
    public Users signUp(UsersRequest.SignUpUserDto request) {
        Users user = UsersConverter.toUsers(request);
        return usersWriteRepository.save(user);
    }

    /**
     * 로그인
     *
     * @param request: UsersRequest.SignInUserDto
     * @return Users
     */
    @Transactional(readOnly = true)
    public Users signIn(UsersRequest.SignInUserDto request) {
        Users user = usersReadRepository.findByEmail(request.getEmail());
        return user;
    }

    /**
     * 비밀번호 변경
     *
     * @param request: UsersRequest.ChangePasswordUserDto
     * @return Users
     */
    @Transactional
    public Users changePassword(UsersRequest.ChangePasswordUserDto request) {
        Users user = usersReadRepository.findByEmail(request.getEmail());
        passwordUtil.isChangeable(user.getPassword(), request.getNewPassword());
        user.changePassword(request.getNewPassword());
        return usersWriteRepository.save(user);
    }

    /**
     * 회원정보 조회
     *
     * @param nickname: String
     * @return Users
     */
    @Transactional(readOnly = true)
    public Users getUsersByNickname(String nickname) {
        return usersReadRepository.findByNickname(nickname);
    }

    /**
     * 회원정보 조회
     *
     * @param userId: Long
     * @return Users
     */
    @Transactional(readOnly = true)
    public Users getUsersById(Long userId) {
        return usersReadRepository.findById(userId).orElseThrow();
    }

    /**
     * 회원정보 조회
     *
     * @param email: String
     * @return Users
     */
    @Transactional(readOnly = true)
    public Users getUsersByEmail(String email) {
        return usersReadRepository.findByEmail(email);
    }
}
