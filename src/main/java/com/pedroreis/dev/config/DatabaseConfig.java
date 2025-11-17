package com.pedroreis.dev.config;

import com.pedroreis.dev.GithubClient;
import com.pedroreis.dev.model.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class DatabaseConfig {
    public static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
    private final GithubClient githubClient;

    public DatabaseConfig(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Bean
    @Profile("dev")
    CommandLineRunner seedTables() {
        return args -> {
            LOG.info("[Config:DB] Updating Tables...");
            List<Repo> repos = githubClient.fetchRepos();
            LOG.info("Total Repos: {}", repos.size());
            repos.forEach(Repo::save);
            LOG.info("[Config:DB] Tables updated!");
        };
    }
}
