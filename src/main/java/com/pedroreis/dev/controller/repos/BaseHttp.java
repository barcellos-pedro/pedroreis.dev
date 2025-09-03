package com.pedroreis.dev.controller.repos;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pedroreis.dev.model.Repo;

public class BaseHttp {
    protected HttpClient getHttpClient() {
        return HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    protected HttpRequest getRequest(String url) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(getUri(url))
                .GET()
                .build();
    }

    protected URI getUri(String url) throws URISyntaxException {
        return new URI(url);
    }

    protected List<Repo> parse(HttpResponse<String> response) throws JsonProcessingException, JsonMappingException {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(SNAKE_CASE)
                .readValue(response.body(), new TypeReference<List<Repo>>() {
                });
    }
}
