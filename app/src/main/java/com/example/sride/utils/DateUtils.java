package com.example.sride.utils;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {

    public static String getDayString(int dayOfWeekInt) {
        DateFormatSymbols dfs = new DateFormatSymbols();
        return dfs.getWeekdays()[dayOfWeekInt];
    }

    public static String getDateInString(int dayOfMonth, int monthOfYear, int year) {
        Calendar calendar = getCalendar(dayOfMonth, monthOfYear, year);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY",
                Locale.ENGLISH);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static long getUnixTime(int dayOfMonth, int monthOfYear, int year) {
        Calendar calendar = getCalendar(dayOfMonth, monthOfYear, year);
        long timeInLong = calendar.getTimeInMillis();
        return timeInLong / 1000L;
    }

    private static Calendar getCalendar(int dayOfMonth, int monthOfYear, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        return calendar;
    }

    public static String getDayOfWeek(int dayOfMonth, int monthOfYear, int year) {
        Calendar calendar = getCalendar(dayOfMonth, monthOfYear, year);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return getDayString(dayOfWeek);
    }
}
