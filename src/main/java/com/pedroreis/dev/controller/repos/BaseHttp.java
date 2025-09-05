package com.pedroreis.dev.controller.repos;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

import java.net.URI;
import java.net.URISyntaxException;
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
    public static final String BASE_URL = "https://api.github.com";

    public static HttpRequest getRequest(String path) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + path))
                .GET()
                .build();
    }

    public static List<Repo> parse(HttpResponse<String> response) throws JsonProcessingException, JsonMappingException {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(SNAKE_CASE)
                .readValue(response.body(), new TypeReference<List<Repo>>() {
                });
    }
}
