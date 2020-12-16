package com.ace.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice//可以处理所有类中的异常
public class MyExceptionHandler {
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorInfo", e.getMessage()); // by zero
		return mav;
	}

}
