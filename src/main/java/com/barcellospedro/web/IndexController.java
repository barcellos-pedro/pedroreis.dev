package com.barcellospedro.web;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private final JdbcTemplate db;

    public IndexController(JdbcTemplate template) {
        db = template;
    }

    @GetMapping("/")
    public String githubUser(HttpServletRequest request, Model model) {
        var totalVisits = db.queryForObject("SELECT count(*) FROM visits", String.class);

        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();

        log.info("date time: {}", getCurrentDateTime());
        log.info("total visits:  {}", totalVisits);
        log.info("path:  {}", path);
        log.info("ip: {}", ipAddress);

        model.mergeAttributes(Map.of(
                "avatarUrl", "https://avatars.githubusercontent.com/u/33139500?v=4",
                "visits", totalVisits
        ));

        db.update("INSERT INTO visits (ip_address, user_agent, page_path) VALUES (?, ?, ?)",
                ipAddress, userAgent, path);

        return "home";
    }

    private static String getCurrentDateTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
