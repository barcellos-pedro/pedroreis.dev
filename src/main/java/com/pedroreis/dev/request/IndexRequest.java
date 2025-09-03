package com.pedroreis.dev.request;

import org.springframework.http.HttpHeaders;

import jakarta.servlet.http.HttpServletRequest;

public record IndexRequest(String userAgent, String path, String ipAddress) {
    
    public static IndexRequest of(HttpServletRequest request) {
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();
        return new IndexRequest(userAgent, path, ipAddress);
    }
}
