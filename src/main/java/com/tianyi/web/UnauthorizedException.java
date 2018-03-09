package com.tianyi.web;

/**
 * Created by lingqing.wan on 2015/12/29.
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("未授权");
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    protected UnauthorizedException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}