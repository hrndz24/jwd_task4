package com.buyanova.exception;

public class XMLValidatorException extends Exception {
    public XMLValidatorException() {
    }

    public XMLValidatorException(String message) {
        super(message);
    }

    public XMLValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLValidatorException(Throwable cause) {
        super(cause);
    }

    public XMLValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
