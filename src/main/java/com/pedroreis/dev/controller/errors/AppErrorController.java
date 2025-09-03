package com.pedroreis.dev.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class AppErrorController extends ErrorControllerBase implements ErrorController {
    private static final Logger log = LoggerFactory.getLogger(AppErrorController.class);

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object errorCode = request.getAttribute(ERROR_STATUS_CODE);

        if (getHttpStatusOf(errorCode).equals(NOT_FOUND)) {
            log.warn("[ERROR:404] Page not found");
            return "errors/404";
        }

        log.error("[ERROR:5xx] General error occurred", getExceptionOf(request));
        return "errors/500";
    }
}