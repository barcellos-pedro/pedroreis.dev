package com.pedroreis.dev.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Topic extends BaseModel {
    public Topic() {
    }

    public static void create(List<String> topics, String repoId) {
        String topicList = String.join(", ", topics);
        create(topicList, repoId);
    }

    public static void create(String topics, String repoId) {
        jdbcTemplate.update("INSERT INTO topics (topic_list, repo_id) VALUES (?, ?)", topics, repoId);
    }
}
