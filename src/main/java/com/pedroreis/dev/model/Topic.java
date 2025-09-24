package com.pedroreis.dev.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Topic extends ActiveRecord {

    public Topic() {
    }

    public static void create(String topics, String repoId) {
        jdbcTemplate.update("INSERT INTO topics (topic_list, repo_id) VALUES (?, ?)", topics, repoId);
    }

    public static void create(List<String> topics, String repoId) {
        String topicList = String.join(", ", topics);
        create(topicList, repoId);
    }
    }
