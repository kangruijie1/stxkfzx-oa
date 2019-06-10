package xyz.stxkfzx.manager.common.enums;

public enum GeneralEnum {
    /**
     * 成功
     */
    SUCCESS("成功", 200),

    /**
     * 失败
     */
    FAIL("失败", 500);


    private String msg;
    private Integer code;

    GeneralEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
