package xyz.stxkfzx.manager.face.utils;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class GetWeek
{
    public static final String startDate = "2019-02-25";
    public static SimpleDateFormat format;
    
    static {
        GetWeek.format = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public static int getWeekNumber() throws ParseException {
        final Date fDate1 = GetWeek.format.parse("2019-02-25");
        final Date date = new Date();
        final Timestamp timeStamp = new Timestamp(date.getTime());
        final String today = timeStamp.toString().split(" ")[0];
        final Date fDate2 = GetWeek.format.parse(today);
        final long days = (fDate2.getTime() - fDate1.getTime()) / 86400000L;
        int week = (int)(days / 7L);
        return ++week;
    }
    
    public static int getWeekNumber(final String today) throws ParseException {
        final Date fDate1 = GetWeek.format.parse("2019-02-25");
        final Date fDate2 = GetWeek.format.parse(today);
        final long days = (fDate2.getTime() - fDate1.getTime()) / 86400000L;
        final int week = (int)(days % 7L);
        return (week % 7 == 0) ? 1 : (week % 7 + 1);
    }
    
    public static List<String> getWeekStartEndDate(int week) throws ParseException {
        List<String> list = new ArrayList<String>();
        long num = (week - 1) * 7;
        long num2 = num + 6L;
        Date date = GetWeek.format.parse("2019-02-25");
        long time = date.getTime();
        long time2 = num * 24L * 60L * 60L * 1000L;
        long time3 = num2 * 24L * 60L * 60L * 1000L;
        time2 += time;
        time3 += time;
        Date date2 = new Date(time2);
        String format1 = GetWeek.format.format(date2);
        list.add(format1);
        Date date3 = new Date(time3);
        String format2 = GetWeek.format.format(date3);
        list.add(format2);
        return list;
    }
    
    public static String getTodayDate() {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        String today = timeStamp.toString().split(" ")[0];
        return today;
    }
    
    public static String getTodayStartDate() {
    	return getTodayDate() + " 00:00:00.000";
    }
    public static String getTodayEndDate() {
    	return getTodayDate() + " 23:59:59.999";
    }
    
    public static Timestamp getTodayTime() {
        final Date date = new Date();
        final Timestamp todayTime = new Timestamp(date.getTime());
        return todayTime;
    }
}
