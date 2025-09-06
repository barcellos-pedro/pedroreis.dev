package com.pedroreis.dev.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Templates {
    public static String join(List<String> list) {
        return String.join(", ", list);
    }

    public static String date(Instant date) {
        return DateTimeFormatter.ofPattern(DateUtils.DATE_PATTERN)
                .withZone(ZoneId.systemDefault())
                .format(date);
    }
}
