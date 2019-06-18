package xyz.stxkfzx.manager.face.enums;

public enum ImgEnum {
    /**
     * 上班类型
     */
    SIGN_IN((short)1, "上班"),

    /**
     * 下班类型
     */
    SIGN_OUT((short)2, "下班"),

    ;
    private Short signItemType;
    private String typeName;

    ImgEnum(Short signItemType, String typeName) {
        this.signItemType = signItemType;
        this.typeName = typeName;
    }

    public Short getSignItemType() {
        return signItemType;
    }

    public String getTypeName() {
        return typeName;
    }
}
