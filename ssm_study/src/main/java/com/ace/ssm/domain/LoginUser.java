package com.ace.ssm.domain;

public class LoginUser {
	
	private String userName;//用户名称
	private String loginPwd;//用户登录密码
	private Integer userType;//表示用户的类型，如 1：普通用户，2：管理员用户等
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoginUser [userName=" + userName + ", loginPwd=" + loginPwd + ", userType=" + userType + "]";
	}
	
	
}
