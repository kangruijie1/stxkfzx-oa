package xyz.stxkfzx.manager.common.enums;

public enum SignEnum {
	/**
	 * 未录入人脸
	 */
	NOT_INPUT_FACE("请先录入人脸库！", 510),

	/**
	 * 打卡成功(上班)
	 */
	SIGN_IN_SUCCESS("打卡(上班)成功！", 210),

	/**
	 * 打卡成功（下班）
	 */
	SIGN_OUT_SUCCESS("打卡(下班)成功！", 211),

	/**
	 * 未在指定地点打卡
	 */
	SITE_NOT_IN_KFZX("请在指定地点签到！", 512);

	private String msg;
	private Integer code;

	SignEnum(String msg, Integer code) {
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
