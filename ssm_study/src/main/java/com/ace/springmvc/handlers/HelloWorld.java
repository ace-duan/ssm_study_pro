package com.ace.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//https://ke.qq.com/course/159860?taid=817843377696884

@Controller
public class HelloWorld {
	
	//常量
	private static final String SUCCESS = "success";
	
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("ace");
		return SUCCESS;
	}
}
