package com.pedroreis.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedroreis.dev.utils.DateUtils;

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
public record Repo(
        String name,
        String htmlUrl,
        String description,
        Instant createdAt,
        List<String> topics) {

    public static Repo of(ResultSet resultSet) throws SQLException {
        var createdAt = DateUtils.getDate(resultSet.getString("createdAt"));
        var topicList = resultSet.getString("topic_list");
        List<String> topics = topicList.isBlank() ?
                Collections.emptyList() :
                List.of(topicList.split(", "));

        return new Repo(resultSet.getString("repo_name"),
                resultSet.getString("htmlUrl"),
                resultSet.getString("description"),
                createdAt,
                topics);
    }
}
