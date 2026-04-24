package com.gamezone.rental.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatHelper {

    // Method to format currency in Rupiah
    public static String formatCurrencyInRupiah(double amount) {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("id", "ID"));
        return decimalFormat.format(amount);
    }

    // Method to format a given date string
    public static String formatDate(String dateString) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            Date date = inputFormat.parse(dateString);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}