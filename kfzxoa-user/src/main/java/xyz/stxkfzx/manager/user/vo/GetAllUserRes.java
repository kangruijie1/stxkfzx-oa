package xyz.stxkfzx.manager.user.vo;

import java.util.List;

public class GetAllUserRes {
    private String department;
    private List<TUserVO> userVOS;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<TUserVO> getUserVOS() {
        return userVOS;
    }

    public void setUserVOS(List<TUserVO> userVOS) {
        this.userVOS = userVOS;
    }
}
