package xyz.stxkfzx.manager.common.pojo;


import xyz.stxkfzx.manager.common.contants.SignContants;

public class FaceResult {
	
	private Object data;
	private Integer status;
	private String msg;
	public FaceResult() {
		super();
	}
	
	public FaceResult ok(Object data) {
		this.data = data;
		this.status = SignContants.SUCCESS;
		this.msg = "成功！";
		return this;
	}


	public FaceResult(Object data, Integer status, String msg) {
		this.data = data;
		this.status = status;
		this.msg = msg;
	}
	public FaceResult(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
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
