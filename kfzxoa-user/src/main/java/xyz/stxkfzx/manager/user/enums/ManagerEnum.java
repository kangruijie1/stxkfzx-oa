package xyz.stxkfzx.manager.user.enums;

import org.apache.catalina.Manager;

public enum ManagerEnum {

    /**
     * 学员
     */
    STUDENT("学员", 1),

    /**
     * 副部长
     */
    VICE_MINISTER("副部长", 5),

    /**
     * 部长
     */
    MINISTER("部长", 10),

    /**
     * 行政
     */
    ADMIN("行政", 50),

    /**
     * 人事
     */
    HR("人事", 75),

    /**
     * 队长
     */
    CAPTAIN("队长", 100)

    ;

    private String managerType;
    private Integer managerCode;

    ManagerEnum(String managerType, Integer managerCode){
        this.managerType = managerType;
        this.managerCode = managerCode;
    }

    public Integer getManagerCode() {
        return managerCode;
    }

    public String getManagerType() {
        return managerType;
    }

    ManagerEnum(){
    }
}
