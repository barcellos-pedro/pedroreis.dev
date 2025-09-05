package com.pedroreis.dev.config;

import com.pedroreis.dev.controller.repos.BaseHttp;
import com.pedroreis.dev.model.Repo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.http.HttpClient;
import java.util.List;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

@Configuration
public class DatabaseConfig {

    public static final String PATH = "/users/barcellos-pedro/repos?sort=created&per_page=100&page=1";
    public static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
    public final HttpClient httpClient;

    public DatabaseConfig() {
        httpClient = HttpClient.newBuilder().build();
    }

    @PostConstruct
    public void onInit() {
        LOG.info("[Config:DB] Updating Tables...");
    }

    @Bean
    CommandLineRunner seedTables(JdbcTemplate jdbcTemplate) {
        return args -> {
            var request = BaseHttp.getRequest(PATH);
            var response = httpClient.send(request, ofString());
            List<Repo> repos = BaseHttp.parse(response);

            LOG.info("[Config:DB] GitHub API: Status code: {} | Total Repos: {}",
                    response.statusCode(), repos.size());

            repos.forEach(repo -> {
                createRepo(jdbcTemplate, repo);
                createTopics(jdbcTemplate, repo);
            });

            LOG.info("[Config:DB] Tables updated!");
        };
    }

    private void createTopics(JdbcTemplate jdbcTemplate, Repo repo) {
        var id = getRepoId(jdbcTemplate, repo);
        var topics = String.join(", ", repo.topics());
        jdbcTemplate.update("INSERT INTO topics (topic_list, repo_id) VALUES (?, ?)", topics, id);
    }

    private static Integer getRepoId(JdbcTemplate jdbcTemplate, Repo repo) {
        return jdbcTemplate.queryForObject("SELECT id FROM repos WHERE name = ?",
                Integer.class,
                repo.name());
    }

    public void createRepo(JdbcTemplate jdbcTemplate, Repo repo) {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                repo.name(), repo.htmlUrl(), repo.description());
    }
}
