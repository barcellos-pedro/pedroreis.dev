package com.pedroreis.dev.request;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public record IndexRequest(String userAgent, String path, String ipAddress) {

    public static IndexRequest of(HttpServletRequest request) {
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();
        return new IndexRequest(userAgent, path, ipAddress);
    }
}
