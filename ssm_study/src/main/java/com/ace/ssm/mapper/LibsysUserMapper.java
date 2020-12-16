package com.ace.ssm.mapper;

import com.ace.ssm.domain.libsys.User;

public interface LibsysUserMapper {

	//user login
	User login(User user);

//	void updateByPrimaryKeySelective(User user);
}
