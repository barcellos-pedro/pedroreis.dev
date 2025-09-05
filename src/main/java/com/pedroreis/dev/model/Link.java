package com.pedroreis.dev.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public record Link(String title, String url) {

    public static Link of(ResultSet resultSet) throws SQLException {
        return new Link(resultSet.getString("title"), resultSet.getString("url"));
    }
}
