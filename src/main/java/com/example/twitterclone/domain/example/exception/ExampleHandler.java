package com.example.twitterclone.domain.example.exception;

import com.example.twitterclone.global.common.code.status.ErrorStatus;
import com.example.twitterclone.global.common.exception.GeneralException;

public class ExampleHandler extends GeneralException {

    public ExampleHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
