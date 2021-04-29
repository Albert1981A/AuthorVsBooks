package com.AlbertAbuav.AuthorVsBooks.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formattedDate(LocalDate localDate) {
        return formatter.format(localDate);
    }

}
