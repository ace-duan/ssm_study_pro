package com.ace.ssm.vo;

import com.ace.ssm.domain.User;

public class UserVo extends User{
	
	private Integer currPage;

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

}
