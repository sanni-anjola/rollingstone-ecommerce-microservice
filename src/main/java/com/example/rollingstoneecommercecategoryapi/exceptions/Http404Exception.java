package com.example.rollingstoneecommercecategoryapi.exceptions;

public class Http404Exception extends RuntimeException{
    public Http404Exception() {
    }

    public Http404Exception(String message) {
        super(message);
    }

    public Http404Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Http404Exception(Throwable cause) {
        super(cause);
    }

    public Http404Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
