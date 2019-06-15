package xyz.stxkfzx.manager.common.enums;

public enum UserEnum {
    /**
     * 用户名重复
     */
    USERNAME_REPEAT("用户名重复", 510),

    INSERT_USER_FAIL("插入用户失败", 511),

    USERNAME_PASSWORD_IS_FALSE("用户名或密码错误", 514),

    USER_NOT_EXIST("用户不存在", 515),

    /**
     * token为null
     */
    TOKEN_IS_NULL("token为null", 512),
    ;


    private String msg;
    private Integer code;

    UserEnum(String msg, Integer code) {
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
