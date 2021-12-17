package com.example.rollingstoneecommercecategoryapi.exceptions;

public class Http400Exception extends RuntimeException{
    public Http400Exception() {
    }

    public Http400Exception(String message) {
        super(message);
    }

    public Http400Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Http400Exception(Throwable cause) {
        super(cause);
    }

    public Http400Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
