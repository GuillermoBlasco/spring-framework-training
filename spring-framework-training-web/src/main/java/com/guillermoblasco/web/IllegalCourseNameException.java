package com.guillermoblasco.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "illegal course name")
public class IllegalCourseNameException extends RuntimeException {

    private final String entityId;
    private final List<String> badWords;
}
