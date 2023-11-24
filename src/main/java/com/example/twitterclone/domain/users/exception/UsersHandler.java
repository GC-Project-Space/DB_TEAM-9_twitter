package com.example.twitterclone.domain.users.exception;

import com.example.twitterclone.global.common.code.status.ErrorStatus;
import com.example.twitterclone.global.common.exception.GeneralException;

public class UsersHandler extends GeneralException {

    public UsersHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
