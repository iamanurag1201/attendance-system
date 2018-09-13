package com.attendance.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AttendanceDate {

    private static java.util.Date date;

    public static java.sql.Date getUtilToSql() throws Exception {
        return new java.sql.Date(new java.util.Date().getTime());
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd/MMM/yyyy:HH:mm").format(new java.util.Date());
    }

    public static java.sql.Date getStringToSqlDate(String date1) throws ParseException {
        return new java.sql.Date(new SimpleDateFormat("yyyy-MMM-dd").parse(date1).getTime());
    }

    public static String getSqlToString(java.sql.Date date) {
        return new SimpleDateFormat("dd-MMM-yyyy").format(date);
    }

    public static long calculateDays(java.util.Date startDate, java.util.Date lastDate) {
        return (startDate.getTime() - lastDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    public static java.util.Date stringToDate(String date1) throws ParseException {
        return date = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
    }

    public static String dateToString() {
        return new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date());
    }

    public static String dateToString1(String date) {
        return new SimpleDateFormat("MM-dd-yyyy").format(new java.util.Date(date));
    }
    public static void main(String[] args) {
        System.out.println(getCurrentDate());
    }
}
