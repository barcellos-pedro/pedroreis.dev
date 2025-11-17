package com.pedroreis.dev.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private final ResultSet resultSet;
    private final Map<String, String> attributes = new HashMap<>();

    public Schema(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Schema(Builder builder) {
        this.resultSet = builder.resultSet;

        List<String> values = getStrings(builder.attributes);

        for (var i = 0; i < builder.attributes.length; i++) {
            var key = builder.attributes[i];
            var value = values.get(i);
            this.attributes.put(key, value);
        }
    }

    public static Schema of(ResultSet resultSet) {
        return new Schema(resultSet);
    }

    public String getString(String attribute) {
        try {
            return resultSet.getString(attribute);
        } catch (SQLException __) {
            return "";
        }
    }

    public List<String> getStrings(String... attributes) {
        var result = new ArrayList<String>(attributes.length);

        for (var attr : attributes) {
            var value = getString(attr);
            result.add(value);
        }

        return result;
    }

    public Map<String, String> attributes() {
        return attributes;
    }

    public static class Builder {

        private ResultSet resultSet;
        private String[] attributes;

        public Builder attributes(String... attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder resultSet(ResultSet resultSet) {
            this.resultSet = resultSet;
            return this;
        }

        public Schema build() {
            return new Schema(this);
        }
    }
}
