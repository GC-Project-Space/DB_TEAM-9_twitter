package com.example.twitterclone.domain.follow.exception;

import com.example.twitterclone.global.common.code.status.ErrorStatus;
import com.example.twitterclone.global.common.exception.GeneralException;

public class FollowHandler extends GeneralException {

    public FollowHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
