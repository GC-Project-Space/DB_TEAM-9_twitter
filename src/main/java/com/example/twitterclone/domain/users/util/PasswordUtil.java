package com.example.twitterclone.domain.users.util;

import com.example.twitterclone.domain.users.exception.UsersHandler;
import com.example.twitterclone.global.common.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PasswordUtil {

    public void isChangeable(String nowPwd, String newPwd) {
        if (nowPwd.equals(newPwd)) {
            throw new UsersHandler(ErrorStatus.PASSWORD_CANNOT_BE_CHANGED);
        }
    }
}
