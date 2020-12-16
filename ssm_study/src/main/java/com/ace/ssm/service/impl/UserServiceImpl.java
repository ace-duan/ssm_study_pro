package com.ace.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.ssm.domain.User;
import com.ace.ssm.mapper.UserMapper;
import com.ace.ssm.service.UserService;
import com.ace.ssm.utils.PageBean;
import com.ace.ssm.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> queryUserForPage(PageBean pageBean, UserVo userVo) {

		Page<User> page = PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());
		List<User> list = this.userMapper.queryAllUser(userVo);
		//得到总条数
		pageBean.setTotalCount((int)page.getTotal());
		return list;
	}

}
