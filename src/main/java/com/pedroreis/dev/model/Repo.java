package com.pedroreis.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedroreis.dev.utils.Date;
import com.pedroreis.dev.utils.Schema;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

/// Repository model
/// Used to map the JSON response from GitHub API
/// and also to map the database result set
///
/// Fields:
/// - name      = {repo_name}
/// - fullName  = {user/repo_name}
/// - htmlUrl   = repository GitHub page
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo extends ActiveRecord {
        private String name;
        private String htmlUrl;
        private String description;
        private Instant createdAt;
        private List<String> topics;
        public static final String REPOS_WITH_TOPICS_QUERY = "SELECT r.id AS repo_id, r.name AS repo_name, r.htmlUrl, r.description, r.createdAt, t.id AS topic_id, t.topic_list, t.repo_id FROM repos r INNER JOIN topics t ON r.id = t.repo_id;";

        public Repo() {
        }

        public Repo(String name, String htmlUrl, String description, Instant createdAt, List<String> topics) {
                this.name = name;
                this.topics = topics;
                this.htmlUrl = htmlUrl;
                this.createdAt = createdAt;
                this.description = description;
        }

        public Repo(List<String> fields) {
                this.createdAt = Date.getDate(fields.get(0));
                this.description = fields.get(1);
                this.topics = fields.get(2).isBlank() ? Collections.emptyList() : List.of(fields.get(2).split(", "));
                this.name = fields.get(3);
                this.htmlUrl = fields.get(4);
        }

        public static Repo of(ResultSet resultSet) throws SQLException {
                List<String> fields = Schema.of(resultSet)
                                .strings("createdAt", "description", "topic_list", "repo_name", "htmlUrl");
                return new Repo(fields);
        }

        public static List<Repo> all() {
                return jdbcTemplate.query(REPOS_WITH_TOPICS_QUERY, (resultSet, rowNum) -> Repo.of(resultSet));
        }

        public String name() {
                return name;
        }

        public String htmlUrl() {
                return htmlUrl;
        }

        public String description() {
                return description;
        }

        public Instant createdAt() {
                return createdAt;
        }

        public List<String> topics() {
                return topics;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setHtmlUrl(String htmlUrl) {
                this.htmlUrl = htmlUrl;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setCreatedAt(Instant createdAt) {
                this.createdAt = createdAt;
        }

        public void setTopics(List<String> topics) {
                this.topics = topics;
        }
}
