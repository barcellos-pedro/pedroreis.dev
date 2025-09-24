package com.pedroreis.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedroreis.dev.utils.Date;
import com.pedroreis.dev.utils.Schema;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
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
@Component
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
        var topics = fields.get(5);
        this.id = fields.get(0);
        this.name = fields.get(1);
        this.htmlUrl = fields.get(2);
        this.description = fields.get(3);
        this.createdAt = Date.getDate(fields.get(4));
        this.topics = topics.isBlank() ? List.of() : List.of(topics.split(", "));
    }

    public static Repo of(ResultSet resultSet) throws SQLException {
        List<String> fields = Schema.of(resultSet)
                .strings("repo_id", "repo_name", "htmlUrl", "description", "createdAt", "topic_list");
        return new Repo(fields);
    }

    public static List<Repo> all() {
        return jdbcTemplate.query(REPOS_WITH_TOPICS_QUERY, (resultSet, rowNum) -> Repo.of(resultSet));
    }

    public static String getId(Repo repo) {
        return jdbcTemplate.queryForObject("SELECT id FROM repos WHERE name = ?", String.class, repo.name());
    }

    public static void create(Repo repo) {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                repo.name(), repo.htmlUrl(), repo.description());
    }

    public void save() {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                name(), htmlUrl(), description());

        var id = Repo.getId(this);
        Topic.create(topics, id);
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

    @Override
    public String toString() {
        return "Repo [id = " + id + ", name=" + name + ", htmlUrl=" + htmlUrl +
                ", description=" + description + ", createdAt="
                + createdAt + ", topics=" + topics + "]";
    }
}
