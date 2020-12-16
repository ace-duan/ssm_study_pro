package com.ace.ssm.domain;

import java.util.List;

public class Department {

	private String id;//表示部门编号
	private String name;//部门名称
	private List<Employee> emps;//表示该集合下的员工信息
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	
}
