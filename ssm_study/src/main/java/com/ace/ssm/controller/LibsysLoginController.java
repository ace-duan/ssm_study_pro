package com.ace.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ace.ssm.domain.libsys.User;
import com.ace.ssm.service.LibsysUserService;
import com.ace.ssm.vo.libsys.UserVo;

@Controller
@RequestMapping(value = "/libsys/user")
public class LibsysLoginController {

	@Autowired
	private LibsysUserService libsysUserService;

	@RequestMapping("/tologin")
	public String toLogin() {
		return "libsys_login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVo userVo, HttpSession session, Model model) {
		User user = libsysUserService.login(userVo);
		if (null != user) {
			session.setAttribute("user", user);
			// update login time
			this.libsysUserService.updateUser(user.getUserid());
			return "redirect:/bookInfo/queryAllBookInfo";
		} else {
			model.addAttribute("error", "username or password is incorrect");
			return "libsys_login";
		}

	}
}
