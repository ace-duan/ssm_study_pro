package com.ace.ssm.domain.libsys;

import java.util.Date;

public class User {
	private Integer userid;
	private String usercode;
	private String password;
	private String email;
	private String gender;
	private Date registertime;
	private Date lastlogintime;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public Date getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", usercode=" + usercode + ", password=" + password + ", email=" + email
				+ ", gender=" + gender + ", registertime=" + registertime + ", lastlogintime=" + lastlogintime + "]";
	}

}

