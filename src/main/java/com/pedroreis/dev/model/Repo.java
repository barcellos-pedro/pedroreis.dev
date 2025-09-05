package com.pedroreis.dev.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedroreis.dev.utils.DateUtils;

/// Repository
/// - name      = {repo_name}
/// - fullName  = {user/repo_name}
/// - htmlUrl   = repository github page
@JsonIgnoreProperties(ignoreUnknown = true)
public record Repo(
                String name,
                String htmlUrl,
                String description,
                Instant createdAt,
                List<String> topics) {

        public static Repo of(ResultSet resultSet) throws SQLException {
                var createdAt = DateUtils.getDate(resultSet.getString("createdAt"));
                var topics = List.of(resultSet.getString("topic_list").split(", "));

                return new Repo(resultSet.getString("repo_name"),
                                resultSet.getString("htmlUrl"),
                                resultSet.getString("description"),
                                createdAt,
                                topics);
        }
}
