package com.pedroreis.dev;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final JdbcTemplate db;

    public HomeController(JdbcTemplate db) {
        this.db = db;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        incrementVisits(request);
        log.info("Total visits: {}", getTotalVisits());
        model.addAttribute("links", getLinks());
        return "home";
    }

    private void incrementVisits(HttpServletRequest request) {
        var req = HomeRequest.of(request);
        db.update("INSERT INTO visits (ip_address, user_agent, page_path) VALUES (?, ?, ?)",
                req.ipAddress(), req.userAgent(), req.path());
    }

    private String getTotalVisits() {
        return db.queryForObject("SELECT count(*) FROM visits", String.class);
    }

    private List<Link> getLinks() {
        return db.query("SELECT * FROM links",
                (rs, rowNow) -> new Link(rs.getString("title"), rs.getString("url")));
    }
}
