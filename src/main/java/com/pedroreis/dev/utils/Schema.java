package com.pedroreis.dev.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Schema {

    private final ResultSet resultSet;

    public Schema(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public static Schema of(ResultSet resultSet) {
        return new Schema(resultSet);
    }

    public String string(String field) {
        try {
            return resultSet.getString(field);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public List<String> strings(String... fields) {
        var result = new ArrayList<String>(fields.length);

        for (var field : fields) {
            var value = string(field);
            result.add(value);
        }

        return result;
    }
}
