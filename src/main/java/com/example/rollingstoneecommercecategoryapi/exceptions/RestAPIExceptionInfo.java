package com.example.rollingstoneecommercecategoryapi.exceptions;

import lombok.*;


@AllArgsConstructor
@Getter
public class RestAPIExceptionInfo {
    private final String message;
    private final String details;

    public RestAPIExceptionInfo() {
        message = null;
        details = null;
    }
}
