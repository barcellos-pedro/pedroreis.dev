package com.pedroreis.dev.config;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

import java.net.http.HttpClient;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pedroreis.dev.controller.repos.BaseHttp;
import com.pedroreis.dev.model.Repo;

import jakarta.annotation.PostConstruct;

@Configuration
public class RepoConfig {

    public static final String PATH = "/users/barcellos-pedro/repos?sort=created&per_page=100&page=1";
    public static final Logger LOG = LoggerFactory.getLogger(RepoConfig.class);
    public final HttpClient httpClient;

    public RepoConfig() {
        httpClient = HttpClient.newBuilder().build();
    }

    @PostConstruct
    public void onInit() {
        LOG.info("[Config:Repo] Updating Repos Table...");
    }

    @Bean
    CommandLineRunner seedReposTable(JdbcTemplate jdbcTemplate) {
        return args -> {
            var request = BaseHttp.getRequest(PATH);
            var response = httpClient.send(request, ofString());
            LOG.info("[Request:Repos] Status code: {}", response.statusCode());

            List<Repo> repos = BaseHttp.parse(response);
            LOG.info("[DB:Repos] Size: {}", repos.size());

            repos.forEach(repo -> createRepo(jdbcTemplate, repo));
            LOG.info("[Config:Repo] Repos Table updated!");
        };
    }

    public void createRepo(JdbcTemplate jdbcTemplate, Repo repo) {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                repo.name(), repo.htmlUrl(), repo.description());
    }
}
