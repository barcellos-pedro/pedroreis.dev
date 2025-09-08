package com.pedroreis.dev.controller.repos;

import com.pedroreis.dev.model.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RepoController extends BaseHttp {
    private static final Logger LOG = LoggerFactory.getLogger(RepoController.class);

    @GetMapping("/projects")
    String index(Model model) {
        List<Repo> repos = Repo.all();
        LOG.info("[DB:Repos]: {}", repos.size());
        model.addAttribute("repos", repos);
        return "repos/index";
    }
}
