package com.barcellospedro.web;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String view(Model model) {
        model.addAttribute("text", "home page is working!");
        return "index";
    }

    @GetMapping("/user/{userName}")
    public String githubUser(HttpServletRequest request, Model model, @PathVariable String userName) {
        var totalVisits = db.queryForObject("SELECT count(*) FROM visits", Integer.class);

        String userAgent = request.getHeader("User-Agent");
        String path = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();

        log.info("date time: {}", getCurrentDateTime());
        log.info("total visits:  {}", totalVisits);
        log.info("path:  {}", path);
        log.info("ip: {}", ipAddress);

        model.mergeAttributes(Map.of(
                "avatarUrl", "https://avatars.githubusercontent.com/u/33139500?v=4",
                "visits", totalVisits.toString(),
                "userName", userName
        ));

        db.update("INSERT INTO visits (ip_address, user_agent, page_path) VALUES (?, ?, ?)",
                ipAddress, userAgent, path);

        return "user";
    }

    private static String getCurrentDateTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
