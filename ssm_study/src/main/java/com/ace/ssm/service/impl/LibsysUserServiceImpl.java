package com.ace.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.ssm.domain.libsys.User;
import com.ace.ssm.mapper.LibsysUserMapper;
import com.ace.ssm.service.LibsysUserService;
import com.ace.ssm.vo.libsys.UserVo;

@Service
public class LibsysUserServiceImpl implements LibsysUserService {

	@Autowired
	private LibsysUserMapper libsysUserMapper;
	
	
	@Override
	public User login(UserVo userVo) {
		return libsysUserMapper.login(userVo);
	}

	@Override
	public void updateUser(Integer userId) {

		User user = new User();
		user.setUserid(userId);
		user.setLastlogintime(new Date());
		//update
		this.libsysUserMapper.updateByPrimaryKeySelective(user);
	}

}
