package com.pedroreis.dev.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseModel {
    protected static JdbcTemplate jdbcTemplate;
    protected String id;

    public BaseModel() {
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate template) {
        jdbcTemplate = template;
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
