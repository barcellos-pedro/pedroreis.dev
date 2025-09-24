package com.pedroreis.dev.utils;

import java.time.Instant;
import java.util.List;

public class Template {
    public static String join(List<String> list) {
        return String.join(", ", list);
    }

    public static String date(Instant date) {
        return Date.getDate(date);
    }
}
