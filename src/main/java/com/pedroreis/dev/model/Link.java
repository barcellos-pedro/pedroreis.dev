package com.pedroreis.dev.model;

import com.pedroreis.dev.utils.Schema;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class Link extends BaseModel {
    private String title;
    private String url;

    private static final String[] ATTRIBUTES = {"title", "url"};

    public Link() {
    }

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Link(List<String> fields) {
        this.title = fields.getFirst();
        this.url = fields.getLast();
    }

    public static Link of(ResultSet resultSet) throws SQLException {
        List<String> fields = Schema.of(resultSet).getStrings(ATTRIBUTES);
        return new Link(fields);
    }

    public static List<Link> all() {
        return jdbcTemplate.query("SELECT * FROM links", (resultSet, rowNuw) -> Link.of(resultSet));
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
