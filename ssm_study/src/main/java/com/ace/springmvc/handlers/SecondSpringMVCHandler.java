package com.ace.springmvc.handlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ace.springmvc.exception.MyArrayIndexOutOfBoundsException;

@Controller
@RequestMapping("/handler")
public class SecondSpringMVCHandler {

	@RequestMapping("/testSimpleMapppingExceptionResolver")
	public String testSimpleMapppingExceptionResolver() {
		System.out.println(1 / 0);
		return "success";
	}
	@RequestMapping("/testExceptionHandler")
	public String testExceptionHandler() {
		System.out.println(1 / 0);
		return "success";
	}
	@RequestMapping("/testExceptionHandler2")
	public String testExceptionHandler2() {
		int[] nums = new int[2];
		System.out.println(nums[2]);
		return "success";
	}
	@RequestMapping("/testMyException")
	public String testMyException(@RequestParam("i") Integer i) throws MyArrayIndexOutOfBoundsException {
		if(i == 3) {
			throw new MyArrayIndexOutOfBoundsException();
		}
		return "success";
	}
	@RequestMapping("/testMyException2")
	public String testMyException2(@RequestParam("i") Integer i) {
		if(i == 3) {
			return "forward:testResponseStatus";
//			return "redirect:testResponseStatus";
		}
		return "success";
	}
	@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="测试ace！")//403
	@RequestMapping("/testResponseStatus")
	public String testResponseStatus() {
		return "success";
	}
	
	//@ExceptionHandler方法只能捕获本类中抛出的异常，如果发生异常的方法和处理异常的方法不在同一个类中，要想处理只需增加一个注解@ControllerAdvice
//	@ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
//	public ModelAndView handlerArithmeticException(Exception e) {
////		@ExceptionHandler方法的参数不能有Map，Model等等，而是只能传入你设定的异常。。
//		System.out.println("异常信息为："+e);
////		ModelAndView modelAndView = new ModelAndView();
////		modelAndView.addObject("e", e);
////		modelAndView.setViewName("error");
////		return modelAndView;
//		
//		ModelAndView mav = new ModelAndView("error");
//		mav.addObject("errorInfo", e.getMessage()); // by zero
//		return mav;
//	}
}
