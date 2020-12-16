package com.ace.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ace.ssm.domain.LoginUser;
import com.ace.ssm.mapper.LoginUserMapper;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = true)
public class LoginUserService {

	@Autowired
	private LoginUserMapper loginUserMapper;
	public LoginUser findUserByUserNameAndPassword(String userName,String loginPwd) {
		return loginUserMapper.findUserByNameAndPwd(userName, loginPwd);
	}
}
