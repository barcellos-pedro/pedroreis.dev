package com.pedroreis.dev.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import static jakarta.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;
import static java.lang.Integer.parseInt;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public abstract class ErrorControllerBase {
    protected static Throwable getExceptionOf(HttpServletRequest request) {
        return (Throwable) request.getAttribute(ERROR_EXCEPTION);
    }

    protected static HttpStatus getHttpStatusOf(HttpServletRequest request) {
        Object errorCode = request.getAttribute(ERROR_STATUS_CODE);
        return getHttpStatusOf(errorCode);
    }


    protected static HttpStatus getHttpStatusOf(Object errorCode) {
        if (errorCode == null)
            return INTERNAL_SERVER_ERROR;

        return isNotFoundError(errorCode) ? NOT_FOUND : INTERNAL_SERVER_ERROR;
    }

    protected static boolean isNotFoundError(Object errorCode) {
        return parseInt(errorCode.toString()) == NOT_FOUND.value();
    }
}
