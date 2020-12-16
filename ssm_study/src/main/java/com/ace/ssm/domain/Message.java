package com.ace.ssm.domain;

public class Message {

	private boolean status;
	private String msg;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [status=" + status + ", msg=" + msg + "]";
	}
	
}
