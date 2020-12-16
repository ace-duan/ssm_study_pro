package com.ace.ssm.service;

import com.ace.ssm.domain.libsys.User;
import com.ace.ssm.vo.libsys.UserVo;

public interface LibsysUserService {

	// login
	User login(UserVo userVo);

	// Update the last login time of the user
	void updateUser(Integer userId);
}
