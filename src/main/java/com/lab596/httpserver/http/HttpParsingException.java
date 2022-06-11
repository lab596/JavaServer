package com.lab596.httpserver.http;

public class HttpParsingException extends Exception {

    private final HttpStatusCodes errorCode;

    public HttpParsingException(HttpStatusCodes errorCode) {
        super(errorCode.MESSAGE);
        this.errorCode = errorCode;
    }

    public HttpStatusCodes getErrorCode() {
        return errorCode;
    }

}
