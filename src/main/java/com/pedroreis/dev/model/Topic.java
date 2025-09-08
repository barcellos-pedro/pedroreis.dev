package com.pedroreis.dev.model;

import org.springframework.stereotype.Component;

@Component
public class Topic extends ActiveRecord {
    public Topic() {
    }

    public static void create(Repo repo) {
        var id = Repo.getId(repo);
        var topics = String.join(", ", repo.topics());
        jdbcTemplate.update("INSERT INTO topics (topic_list, repo_id) VALUES (?, ?)", topics, id);
    }
}
