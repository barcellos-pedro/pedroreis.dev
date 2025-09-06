package com.pedroreis.dev.controller.repos;

import com.pedroreis.dev.model.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RepoController extends BaseHttp {
    private static final Logger LOG = LoggerFactory.getLogger(RepoController.class);
    private final JdbcTemplate jdbcTemplate;

    public RepoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/projects")
    String index(Model model) {
        List<Repo> repos = getRepos();
        LOG.info("[DB:Repos]: {}", repos.size());
        model.addAttribute("repos", repos);
        return "repos/index";
    }

    private List<Repo> getRepos() {
        String query = """
                        SELECT
                                r.id AS repo_id,
                                r.name AS repo_name,
                                r.htmlUrl,
                                r.description,
                                r.createdAt,
                                t.id AS topic_id,
                                t.topic_list,
                                t.repo_id
                        FROM repos r
                        INNER JOIN topics t ON r.id = t.repo_id;
                """;
        return jdbcTemplate.query(query, (resultSet, rowNum) -> Repo.of(resultSet));
    }
}
