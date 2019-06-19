package xyz.stxkfzx.manager.face.pojo;

import java.util.List;

public class SignItemResultVo {
    private Integer week;
    private List<SignItemResult> signItemList;
    private String department;

    @Override
    public String toString() {
        return "SignItemResultVo{" +
                "week=" + week +
                ", signItemList=" + signItemList +
                ", department='" + department + '\'' +
                '}';
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public List<SignItemResult> getSignItemList() {
        return signItemList;
    }

    public void setSignItemList(List<SignItemResult> signItemList) {
        this.signItemList = signItemList;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public SignItemResultVo() {
    }

    public SignItemResultVo(Integer week, List<SignItemResult> signItemList, String department) {
        this.week = week;
        this.signItemList = signItemList;
        this.department = department;
    }
}
