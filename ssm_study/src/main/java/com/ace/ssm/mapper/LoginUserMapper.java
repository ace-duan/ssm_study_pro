package com.ace.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.ace.ssm.domain.LoginUser;

public interface LoginUserMapper {

	public LoginUser findUserByNameAndPwd(@Param("userName")String userName,@Param("loginPwd")String loginPwd);
}
