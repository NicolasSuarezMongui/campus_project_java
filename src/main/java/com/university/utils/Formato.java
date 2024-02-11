package com.university.utils;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formato {
    private Formato() {
    }

    public static String formatDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static String formatCurrentPesos(double amount) {
        Locale colombiaLocale = new Locale("es", "CO");
        NumberFormat currentFormat = NumberFormat.getCurrencyInstance(colombiaLocale);
        return currentFormat.format(amount);
    }

}
