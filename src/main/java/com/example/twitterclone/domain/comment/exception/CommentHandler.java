package com.example.twitterclone.domain.comment.exception;

import com.example.twitterclone.global.common.code.status.ErrorStatus;
import com.example.twitterclone.global.common.exception.GeneralException;

public class CommentHandler extends GeneralException {

    public CommentHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
