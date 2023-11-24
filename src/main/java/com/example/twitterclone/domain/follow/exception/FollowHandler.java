package com.example.twitterclone.domain.follow.exception;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.example.twitterclone.global.error.exception.GeneralException;

public class FollowHandler extends GeneralException {

    public FollowHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
