package com.pedroreis.dev.controller.repos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pedroreis.dev.model.Repo;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

public abstract class BaseController {
    public static final JavaTimeModule TIME_MODULE;
    public static final ObjectMapper MAPPER;
    public static final String BASE_URL;

    static {
        BASE_URL = "https://api.github.com";
        TIME_MODULE = new JavaTimeModule();
        MAPPER = new ObjectMapper();
    }

    public static HttpRequest getRequest(String path) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + path))
                .GET()
                .build();
    }

    public static List<Repo> parse(HttpResponse<String> response) throws JsonProcessingException {
        return MAPPER.registerModule(TIME_MODULE)
                .setPropertyNamingStrategy(SNAKE_CASE)
                .readValue(response.body(), new TypeReference<>() {
                });
    }
}
