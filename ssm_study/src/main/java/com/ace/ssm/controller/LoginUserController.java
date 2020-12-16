package com.ace.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ace.ssm.domain.LoginUser;
import com.ace.ssm.service.LoginUserService;

@Controller
@RequestMapping(value="/user")
public class LoginUserController {

	@Autowired
	private LoginUserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(LoginUser user ,Map<String,Object> map, HttpSession session) {
		System.out.println(user);
		LoginUser loginUser=userService.findUserByUserNameAndPassword(user.getUserName(), user.getLoginPwd());
		if(loginUser!=null) {
			//把合法的用户登录信息保存到会话域Session中来
			session.setAttribute("user", loginUser);
			//请求转发或重定向到员工管理的主页面上去/emp/emps
			return "redirect:/emp/emps";
//			map.put("info", "["+loginUser.getUserName()+"]登录成功！");
		}else {
			map.put("info", "用户名称或密码错误，登录失败！");
			return "forward:/login.jsp";
		}
//		return "info";
	}
}
