package xyz.stxkfzx.manager.face.enums;

public enum FaceExceptionEnum {

    /**
     * 没有检测到人脸
     */
    NOT_CHECK_FACE(222202, "pic not has face"),

    ;
    private int errorCode;
    private String errorMsg;

    FaceExceptionEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
