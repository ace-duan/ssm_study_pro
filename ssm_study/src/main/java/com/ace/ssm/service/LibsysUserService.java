package com.ace.ssm.service;

import com.ace.ssm.domain.libsys.User;
import com.ace.ssm.vo.libsys.UserVo;

public interface LibsysUserService {

	// login
	User login(UserVo userVo);
//	User login(String usercode,String password);

	// Update the last login time of the user
	void updateUser(Integer userId);
}
