package com.pedroreis.dev.controller;

import com.pedroreis.dev.model.Link;
import com.pedroreis.dev.model.Visit;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Visit.increment(request);
        LOG.info("[DB:Visits]: {}", Visit.all());
        
        var links = Link.all();
        LOG.info("[DB:Links]: {}", links.size());
        model.addAttribute("links", links);
        
        return "index";
    }
}
