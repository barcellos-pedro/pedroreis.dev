package com.pedroreis.dev.controller;

import com.pedroreis.dev.model.Link;
import com.pedroreis.dev.request.IndexRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
    private final JdbcTemplate jdbcTemplate;

    public IndexController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        incrementVisits(request);

        var links = getLinks();

        LOG.info("[DB:Visits]: {}", getTotalVisits());
        LOG.info("[DB:Links]: {}", links.size());

        model.addAttribute("links", links);
        return "index";
    }

    private void incrementVisits(HttpServletRequest request) {
        var req = IndexRequest.of(request);
        jdbcTemplate.update("INSERT INTO visits (ip_address, user_agent, page_path) VALUES (?, ?, ?)",
                req.ipAddress(), req.userAgent(), req.path());
    }

    private String getTotalVisits() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM visits", String.class);
    }

    private List<Link> getLinks() {
        return jdbcTemplate.query("SELECT * FROM links",
                (resultSet, rowNuw) -> Link.of(resultSet));
    }
}
