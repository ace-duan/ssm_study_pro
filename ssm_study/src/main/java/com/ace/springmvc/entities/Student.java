package com.ace.springmvc.entities;

import java.util.Date;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Student {
//	@NumberFormat(pattern="###,#")//表示前台输入格式需要类似123,4
	private int id;
	
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student() {
	}
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//使用格式注解需要 配置数据格式化注解所依赖的bean
//    <bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
//    </bean>
//	@Past //表示必须为过去的时间
//	@DateTimeFormat(pattern="yyyy-MM-dd")//格式化：前台传递来的数据，将前台传递来的数据固定为yyyy-MM-dd
//	private Date birthday;//前端日期必须类似2020-11-03否则报错

	
	
	
}
