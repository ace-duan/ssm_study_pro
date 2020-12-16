package com.ace.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ace.ssm.domain.User;
import com.ace.ssm.service.UserService;
import com.ace.ssm.utils.PageBean;
import com.ace.ssm.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/*
	 * 全查询
	 */
	@RequestMapping("/queryAllUser")
	public String queryAllUser(UserVo userVo,Model model) {
		PageBean pageBean = new PageBean();
		System.out.println(1);
		//判断currPage是否为空，为空则设置1
		if(null==userVo.getCurrPage()) {
			pageBean.setCurrentPage(1);
		}else {
			pageBean.setCurrentPage(userVo.getCurrPage());
		}
		List<User> users = this.userService.queryUserForPage(pageBean, userVo);
		model.addAttribute("users", users);
		model.addAttribute("page", pageBean);
		return "list";
	}

}
