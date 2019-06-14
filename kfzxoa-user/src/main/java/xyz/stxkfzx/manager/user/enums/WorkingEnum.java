package xyz.stxkfzx.manager.user.enums;

public enum WorkingEnum {

    /**
     * 未激活
     */
    NOT_ACTIVE("未激活", (short) 0),

    /**
     * 已入部
     */
    IN_THE_DEPARTMENT("在部", (short) 1),

    /**
     * 退部
     */
    OUT_THE_DEPARTMENT("退部", (short) 2);

    private String workingStatusName;
    private Short workingStatusCode;

    WorkingEnum() {
    }

    WorkingEnum(String workingStatusName, Short workingStatusCode) {
        this.workingStatusName = workingStatusName;
        this.workingStatusCode = workingStatusCode;
    }

    public String getWorkingStatusName() {
        return workingStatusName;
    }

    public Short getWorkingStatusCode() {
        return workingStatusCode;
    }
}
