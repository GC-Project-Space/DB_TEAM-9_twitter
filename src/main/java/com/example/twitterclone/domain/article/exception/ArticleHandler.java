package com.example.twitterclone.domain.article.exception;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.example.twitterclone.global.error.exception.GeneralException;

public class ArticleHandler extends GeneralException {

    public ArticleHandler(ErrorCode errorCode) {
        super(errorCode);
    }
}
