package com.pedroreis.dev;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Controller
public class RepoController {
    private static final Logger log = LoggerFactory.getLogger(RepoController.class);

    private final HttpClient http;

    public RepoController() {
        http = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(500))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    @GetMapping("/projects")
    String index(Model model) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/users/barcellos-pedro/repos?sort=created&per_page=100&page=1"))
                .GET()
                .build();

        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        log.info("Repos Response Status Code: {}", response.statusCode(), body);

        List<Repo> projects = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .readValue(response.body(), new TypeReference<List<Repo>>() {
                });

        int quantity = projects.size();
        log.info("Projects {}", quantity);

        model.mergeAttributes(Map.of(
                "projects", projects,
                "quantity", quantity));

        return "projects";
    }
}
