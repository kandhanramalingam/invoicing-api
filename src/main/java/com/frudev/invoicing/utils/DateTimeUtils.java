package com.frudev.invoicing.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class DateTimeUtils {

    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME,             // 2025-03-15T09:00:00+03:00
            DateTimeFormatter.ISO_ZONED_DATE_TIME,              // 2025-03-15T09:00:00+03:00[Region]
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,             // 2025-03-15T09:00:00
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"), // 2025-03-15T09:00
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),// 2025-03-15 09:00:00
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),    // 2025-03-15 09:00
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),   // 2025-03-15
            DateTimeFormatter.ofPattern("dd/MM/yyyy")    // 15/03/2025
    );

    public static LocalDate parseToLocalDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                // If it's a full ISO format, parse as LocalDateTime then to LocalDate
                if (formatter == DateTimeFormatter.ISO_OFFSET_DATE_TIME ||
                        formatter == DateTimeFormatter.ISO_ZONED_DATE_TIME) {
                    return OffsetDateTime.parse(dateStr, formatter).toLocalDate();
                }

                try {
                    return LocalDate.parse(dateStr, formatter);
                } catch (DateTimeParseException e) {
                    // Try parsing as LocalDateTime and then take the date part
                    return LocalDateTime.parse(dateStr, formatter).toLocalDate();
                }
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }

    public static LocalDateTime parseToLocalDateTime(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;
        System.out.println("parseToLocalDateTime - " + dateStr);

        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                if (formatter == DateTimeFormatter.ISO_OFFSET_DATE_TIME ||
                        formatter == DateTimeFormatter.ISO_ZONED_DATE_TIME) {
                    return OffsetDateTime.parse(dateStr, formatter).toLocalDateTime();
                }

                try {
                    return LocalDateTime.parse(dateStr, formatter);
                } catch (DateTimeParseException e) {
                    if (dateStr.length() == 10) {
                        return LocalDate.parse(dateStr, formatter).atStartOfDay();
                    }
                    throw e;
                }
            } catch (DateTimeParseException ignored) {
                System.out.println("parseToLocalDateTime Failure for date - " + dateStr);
                System.out.println(ignored.getMessage());
            }
        }

        return null;
    }

    public static String formatFromLocalDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}

