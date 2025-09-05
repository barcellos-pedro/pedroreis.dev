package com.pedroreis.dev.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Templates {
    public static String join(List<String> list) {
        return list.stream().collect(Collectors.joining(", "));
    }

    public static String date(Instant date) {
        return DateTimeFormatter.ofPattern(DateUtils.DATE_PATTERN)
                .withZone(ZoneId.systemDefault())
                .format(date);
    }
}
