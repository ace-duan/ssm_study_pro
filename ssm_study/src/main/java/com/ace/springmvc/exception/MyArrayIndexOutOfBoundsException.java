package com.ace.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 用于自定义显示异常信息页面,也可以写在方法前面
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="数组越界！")//403
public class MyArrayIndexOutOfBoundsException extends Exception{//若自定义异常继承Exception即可

	
}
