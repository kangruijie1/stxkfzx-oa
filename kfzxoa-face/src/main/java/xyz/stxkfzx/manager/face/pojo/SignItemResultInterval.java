package xyz.stxkfzx.manager.face.pojo;

import java.sql.*;

public class SignItemResultInterval
{
    private Timestamp signin;
    private Timestamp signout;
    private String interval;
    private int week;
    
    public int getWeek() {
        return this.week;
    }
    
    public void setWeek(final int week) {
        this.week = week;
    }
    
    public SignItemResultInterval(final Timestamp signin, final Timestamp signout, final String interval, final int week) {
        this.signin = signin;
        this.signout = signout;
        this.interval = interval;
        this.week = week;
    }
    
    public SignItemResultInterval() {
    }
    
    public SignItemResultInterval(final Timestamp signin, final Timestamp signout, final String interval) {
        this.signin = signin;
        this.signout = signout;
        this.interval = interval;
    }
    
    public String getSignin() {
        final String inTiemStr = this.signin.toString().split(" ")[1];
        return inTiemStr;
    }
    
    public void setSignin(final Timestamp signin) {
        this.signin = signin;
    }
    
    public String getSignout() {
        final String outTiemStr = this.signout.toString().split(" ")[1];
        return outTiemStr;
    }
    
    public void setSignout(final Timestamp signout) {
        this.signout = signout;
    }
    
    public String getInterval() {
        final long startTime = this.signin.getTime();
        final long endTime = this.signout.getTime();
        final double intervalTiem = endTime - startTime;
        return this.interval = Double.toString(intervalTiem / 3600000.0);
    }
    
    public void setInterval(final String interval) {
        this.interval = interval;
    }
    
    public String toString() {
        return "SignItemResultInterval [signin=" + this.signin + ", signout=" + this.signout + ", interval=" + this.interval + ", week=" + this.week + "]";
    }
}
