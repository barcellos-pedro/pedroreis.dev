package com.pedroreis.dev;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/// Repository
/// - name      = {repo_name}
/// - fullName  = {user/repo_name}
/// - htmlUrl   = repository github page
@JsonIgnoreProperties(ignoreUnknown = true)
public record Repo(
        int id,
        String name,
        String htmlUrl,
        String description,
        Instant createdAt,
        List<String> topics) {
}
