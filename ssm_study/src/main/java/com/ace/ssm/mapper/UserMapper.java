package com.ace.ssm.mapper;

import java.util.List;

import com.ace.ssm.domain.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);
	
	List<User> queryAllUser(User user);

}
