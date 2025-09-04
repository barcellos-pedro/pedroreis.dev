package com.pedroreis.dev.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:sqlite:/var/lib/myapp/database.db");
        dataSource.setPoolName("SQLitePool");

        // ✅ This SQL is executed once per new physical connection
        dataSource.setConnectionInitSql("PRAGMA foreign_keys = ON");

        return dataSource;
    }
}
