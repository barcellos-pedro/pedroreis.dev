package com.pedroreis.dev.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Date {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final ZoneId DATE_ZONE = ZoneId.of("America/Sao_Paulo");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static Instant getDate(String date) {
        return LocalDateTime.parse(date, DATE_FORMATTER)
                .atZone(DATE_ZONE)
                .toInstant();
    }

    public static String getDate(Instant date) {
        return DateTimeFormatter.ofPattern(DATE_PATTERN)
                .withZone(DATE_ZONE)
                .format(date);
    }
}
