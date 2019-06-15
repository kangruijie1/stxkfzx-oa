package xyz.stxkfzx.manager.auth.enums;

public enum AuthEnum {

    /**
     * token为null
     */
    TOKEN_IS_NULL("token为null", 512),

    /**
     * 用户认证过期
     */
    TOKEN_IS_LOW("用户认证过期", 513),


    /**
     * 用户已退部或者未激活
     */
    USER_NOT_IN_DEPARTMENT("用户已退部或者未激活", 514),

    /**
     * 请求管理员请求时
     */
    NOT_AUTH_EXECUTE("您没有权限进行此操作", 515)
    ;

    private String msg;
    private Integer code;

    AuthEnum(String msg, Integer code){
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
