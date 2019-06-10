package xyz.stxkfzx.manager.common.pojo;

import xyz.stxkfzx.manager.common.enums.GeneralEnum;
import xyz.stxkfzx.manager.common.enums.SignEnum;
import xyz.stxkfzx.manager.common.enums.UserEnum;

public class FaceResult {
	
	private Object data;
	private Integer status;
	private String msg;
	public FaceResult() {
		super();
	}
	
	public FaceResult ok(Object data) {
		this.data = data;
		this.status = GeneralEnum.SUCCESS.getCode();
		this.msg = GeneralEnum.SUCCESS.getMsg();
		return this;
	}

	public FaceResult fail() {
		this.status = GeneralEnum.FAIL.getCode();
		this.msg = GeneralEnum.FAIL.getMsg();
		return this;
	}

	public FaceResult(Object data, SignEnum signEnum){
		this.data = data;
		this.msg = signEnum.getMsg();
		this.status = signEnum.getCode();
	}

	public FaceResult(SignEnum signEnum){
		this.msg = signEnum.getMsg();
		this.status = signEnum.getCode();
	}

	public FaceResult(UserEnum userEnum){
		this.msg = userEnum.getMsg();
		this.status = userEnum.getCode();
	}

	public FaceResult(GeneralEnum generalEnum){
		this.msg = generalEnum.getMsg();
		this.status = generalEnum.getCode();
	}

	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public String toString() {
		return "FaceResult [data=" + data + ", status=" + status + ", msg=" + msg + "]";
	}
}
