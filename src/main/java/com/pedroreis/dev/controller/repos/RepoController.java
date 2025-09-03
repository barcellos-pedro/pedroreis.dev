package com.pedroreis.dev.controller.repos;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pedroreis.dev.model.Repo;

@Controller
public class RepoController extends BaseHttp {
        private static final Logger log = LoggerFactory.getLogger(RepoController.class);
        public static final String URL = "https://api.github.com/users/barcellos-pedro/repos?sort=created&per_page=100&page=1";

        @GetMapping("/projects")
        String index(Model model) throws IOException, InterruptedException, URISyntaxException {
                var request = getRequest(URL);
                var http = getHttpClient();
                
                var response = http.send(request, ofString());
                log.info("[Repos:Status Code] {}", response.statusCode());

                List<Repo> repos = parse(response);
                model.addAttribute("repos", repos);

                return "repos/index";
        }
}
