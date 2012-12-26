package com.ego.egobinder.server.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServerUtil {

    public static Date getTime(int year, int month, int day) {
        String date = new StringBuilder().append(year).append("/").append(month).append("/").append(day).toString();
        Date utilDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            utilDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilDate;
    }

    public static Date decrementOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    public static Date incrementOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    public static void runDosCommand(String command) throws IOException {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd /c " + command);
            proc.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Date parseDate(String str) {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        /*df.setTimeZone(Constants.UTC_PLUS_ONE);*/
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        /*df.setTimeZone(Constants.UTC_PLUS_ONE);*/
        return df.format(date);
    }

    public static String formatDateShort(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatDateLong(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

}
