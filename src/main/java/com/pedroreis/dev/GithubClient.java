package com.pedroreis.dev;

import com.pedroreis.dev.controller.repos.BaseHttp;
import com.pedroreis.dev.model.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class GithubClient {
    public static final String PATH = "/users/barcellos-pedro/repos?sort=created&per_page=100&page=1";
    private static final Logger LOG = LoggerFactory.getLogger(GithubClient.class);
    public final HttpClient httpClient;

    public GithubClient() {
        httpClient = HttpClient.newBuilder().build();
    }

    public List<Repo> fetchRepos() throws IOException, InterruptedException, URISyntaxException {
        var request = BaseHttp.getRequest(PATH);
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        LOG.info("[Config:DB] GitHub API: Status code: {}", response.statusCode());
        return BaseHttp.parse(response);
    }
}
