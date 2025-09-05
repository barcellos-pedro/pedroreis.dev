package com.pedroreis.dev.controller.repos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pedroreis.dev.model.Repo;

@Controller
public class RepoController extends BaseHttp {
        private static final Logger LOG = LoggerFactory.getLogger(RepoController.class);
        private final JdbcTemplate jdbcTemplate;

        public RepoController(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
        }

        @GetMapping("/projects")
        String index(Model model) throws IOException, InterruptedException, URISyntaxException {
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
