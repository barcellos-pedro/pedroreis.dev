package com.pedroreis.dev;

import org.springframework.http.HttpHeaders;

import jakarta.servlet.http.HttpServletRequest;

public record HomeRequest(String userAgent, String path, String ipAddress) {
    
    public static HomeRequest of(HttpServletRequest request) {
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();
        return new HomeRequest(userAgent, path, ipAddress);
    }
}
