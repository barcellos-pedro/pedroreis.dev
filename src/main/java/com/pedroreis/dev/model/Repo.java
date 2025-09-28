package com.pedroreis.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedroreis.dev.utils.Date;
import com.pedroreis.dev.utils.Schema;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

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

    public static final String[] attributes = {
            "repo_id",
            "repo_name",
            "htmlUrl",
            "description",
            "createdAt",
            "topic_list"
    };

    public Repo() {
    }

    public Repo(String name, String htmlUrl, String description, Instant createdAt, List<String> topics) {
        this.name = name;
        this.topics = topics;
        this.htmlUrl = htmlUrl;
        this.createdAt = createdAt;
        this.description = description;
    }

    public static Repo of(ResultSet resultSet) throws SQLException {
        var schema = getSchema(resultSet);
        var attributes = schema.attributes();

        var repo = new Repo();

        repo.id = attributes.get("repo_id");
        repo.name = attributes.get("repo_name");
        repo.htmlUrl = attributes.get("htmlUrl");
        repo.description = attributes.get("description");
        repo.createdAt = getDate(attributes);
        repo.topics = getTopics(attributes);

        return repo;
    }

    private static Instant getDate(Map<String, String> attributes) {
        return Date.getDate(attributes.get("createdAt"));
    }

    private static List<String> getTopics(Map<String, String> attributes) {
        String topics = attributes.get("topic_list");

        if (topics.isBlank())
            return List.of();

        return List.of(topics.split(", "));
    }

    private static Schema getSchema(ResultSet resultSet) {
        return new Schema.Builder()
                .attributes(attributes)
                .resultSet(resultSet)
                .build();
    }

    public static List<Repo> all() {
        return jdbcTemplate.query("""
                SELECT r.id AS repo_id,
                    r.name AS repo_name,
                    r.htmlUrl,
                    r.description,
                    r.createdAt,
                    t.id AS topic_id,
                    t.topic_list,
                    t.repo_id
                FROM repos r
                INNER JOIN topics t ON r.id = t.repo_id
                """, (resultSet, rowNum) -> Repo.of(resultSet));
    }

    public static String getId(Repo repo) {
        return jdbcTemplate.queryForObject("SELECT id FROM repos WHERE name = ?", String.class, repo.name());
    }

    public String getId() {
        return jdbcTemplate.queryForObject("SELECT id FROM repos WHERE name = ?", String.class, name());
    }

    public static void create(Repo repo) {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                repo.name(), repo.htmlUrl(), repo.description());
    }

    public void save() {
        jdbcTemplate.update("INSERT INTO repos (name, htmlUrl, description) VALUES (?, ?, ?)",
                name(), htmlUrl(), description());

        Topic.create(topics, getId());
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
        return "Repo [id= %s, name=%s, htmlUrl=%s, description=%s, createdAt=%s, topics=%s]"
                .formatted(id, name, htmlUrl, description, createdAt, topics);
    }
}
