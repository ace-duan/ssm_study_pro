package com.ace.ssm.service;

import java.util.List;

import com.ace.ssm.domain.User;
import com.ace.ssm.utils.PageBean;
import com.ace.ssm.vo.UserVo;

public interface UserService {

	public List<User> queryUserForPage(PageBean pageBean, UserVo userVo);
}
