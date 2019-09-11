package xyz.stxkfzx.manager.common.utils;

import xyz.stxkfzx.manager.common.myException.OAException;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class GetWeek
{
    public static final String startDate = "2019-02-25";
    public static SimpleDateFormat format;
    
    static {
        GetWeek.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 时间字符串转为时间戳
     * @param timeStr
     * @return
     */
    public static Timestamp timeStrConverTimestamp(String timeStr){
        try {
            Date date = format.parse(timeStr);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        } catch (ParseException e) {
            throw new OAException(e.getMessage());
        }
    }

    public static String dateAddDay(String startDateStr){
        try {
            Date startDate = format.parse(startDateStr);
            
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.DAY_OF_MONTH, 1);

            Date nextDate = c.getTime();

            String nextDateStr = GetWeek.format.format(nextDate);
            return nextDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("该天的下一天失败 " + e.getMessage());
        }
    }


    /**
     * 获取今天是第几周
     * @return
     */
    public static int getHowWeek() {
        Date fDate1 = null;
        try {
            fDate1 = GetWeek.format.parse("2019-02-25");
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            String today = timeStamp.toString().split(" ")[0];
            Date fDate2 = GetWeek.format.parse(today);
            long days = (fDate2.getTime() - fDate1.getTime()) / 86400000L;
            int week = (int)(days / 7L);
            return ++week;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("获取第几周失败" + e.getMessage());
        }
    }

    /**
     * 获取该天是第几周
     * @return
     */
    public static int getHowWeek(String day) {
        Date fDate1 = null;
        try {
            fDate1 = GetWeek.format.parse("2019-02-25");
            Date datTime = format.parse(day);
            Timestamp timeStamp = new Timestamp(datTime.getTime());
            String today = timeStamp.toString().split(" ")[0];
            Date fDate2 = GetWeek.format.parse(today);
            long days = (fDate2.getTime() - fDate1.getTime()) / 86400000L;
            int week = (int)(days / 7L);
            return ++week;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("获取第几周失败" + e.getMessage());
        }
    }

    /**
     * 获取该天是周几
     * @param day
     * @return
     */
    public static int getWeekNumber(String day){
        try {
            Date fDate1 = GetWeek.format.parse("2019-02-25");
            Date fDate2 = null;
            fDate2 = GetWeek.format.parse(day);
            long days = (fDate2.getTime() - fDate1.getTime()) / 86400000L;
            int week = (int)(days % 7L);
            return (week % 7 == 0) ? 1 : (week % 7 + 1);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("获取该天是周几失败" + e.getMessage());
        }
    }
    
    public static List<String> getWeekStartEndDate(int week){
        try {
            List<String> list = new ArrayList<String>();
            long num = (week - 1) * 7;
            long num2 = num + 6L;
            Date date = null;
            date = GetWeek.format.parse("2019-02-25");
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
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("获取次周开始和结束时间失败" + e.getMessage());
        }
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
        /*Date date = new Date();
        Timestamp startTime = new Timestamp(date.getTime());
        long oneDay = 24L * 60L * 60L * 1000L;
        long endTimeL = startTime.getTime() + oneDay;
        Timestamp endTime = new Timestamp(endTimeL);
        String endStr = endTime.toString().split(" ")[0];
        return endStr;*/
        return getTodayDate() + " 23:59:59.999";
    }
    
    public static Timestamp getCurrentTime() {
        final Date date = new Date();
        final Timestamp todayTime = new Timestamp(date.getTime());
        return todayTime;
    }

    /**
     * 获取俩个日期之间隔了多少天
     */
    public static int getIntervalDay(String startDate, String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse(startDate);
            Date date2 = format.parse(endDate);
            int a = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
            return a +1;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new OAException("获取日期间隔失败" + e.getMessage());
        }
    }
}
