package com.example.twitterclone.domain.users.exception;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.example.twitterclone.global.error.exception.GeneralException;

public class UsersHandler extends GeneralException {

    public UsersHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
