package com.pedroreis.dev.config;

import com.pedroreis.dev.GithubClient;
import com.pedroreis.dev.model.Repo;
import com.pedroreis.dev.model.Topic;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    public static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
    private final GithubClient githubClient;

    public DatabaseConfig(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @PostConstruct
    public void onInit() {
        LOG.info("[Config:DB] Updating Tables...");
    }

    @Bean
    CommandLineRunner seedTables() {
        return args -> {
            var repos = githubClient.fetchRepos();
            LOG.info("Total Repos: {}", repos.size());

            repos.forEach(Repo::create);
            repos.forEach(Topic::create);

            LOG.info("[Config:DB] Tables updated!");
        };
    }
}
