package com.websimba.spring.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "The file is not selected")
@SuppressWarnings("serial")
public class BadFileException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(BadFileException.class);

    public BadFileException() {
    }

    public BadFileException(String message) {
        super(message);
    }

}
