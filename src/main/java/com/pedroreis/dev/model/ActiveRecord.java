package com.pedroreis.dev.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveRecord {
    protected static JdbcTemplate jdbcTemplate;

    public ActiveRecord() {
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        ActiveRecord.jdbcTemplate = jdbcTemplate;
    }
}
