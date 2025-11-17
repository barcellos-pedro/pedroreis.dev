package com.pedroreis.dev.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class AppErrorController extends ErrorControllerBase implements ErrorController {
    private static final Logger LOG = LoggerFactory.getLogger(AppErrorController.class);

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        HttpStatus httpStatus = getHttpStatusOf(request);

        if (httpStatus.equals(NOT_FOUND)) {
            LOG.warn("[ERROR:404] Page not found");
            return "errors/404";
        }

        LOG.error("[ERROR:5xx] General error occurred", getExceptionOf(request));
        return "errors/500";
    }
}