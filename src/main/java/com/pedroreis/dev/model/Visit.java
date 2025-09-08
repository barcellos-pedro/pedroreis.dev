package com.pedroreis.dev.model;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class Visit extends ActiveRecord {
    private String path;
    private String userAgent;
    private String ipAddress;

    public Visit() {
    }

    public Visit(String userAgent, String path, String ipAddress) {
        this.path = path;
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
    }

    public static Visit of(HttpServletRequest request) {
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();
        return new Visit(userAgent, path, ipAddress);
    }

    public static void increment(HttpServletRequest httpServletRequest) {
        var request = Visit.of(httpServletRequest);

        jdbcTemplate.update("INSERT INTO visits (ip_address, user_agent, page_path) VALUES (?, ?, ?)",
                request.ipAddress(), request.userAgent(), request.path());
    }

    public static String all() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM visits", String.class);
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }

    public String userAgent() {
        return userAgent;
    }

    public String ipAddress() {
        return ipAddress;
    }
}
