package com.ace.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	@NotBlank(message = "员工编号不能为空！")
	private String empId;//表示员工编号
	@NotBlank(message="员工姓名不能为空！")
	private String name;//员工姓名
	private Boolean gender=true;//员工性别,true表示男，false表示女
	
	//https://www.cnblogs.com/flying607/p/4691650.html
	@NotNull(message = "入职日期不能为空！")
	@DateTimeFormat(pattern = "yyyy-MM-dd")//作用：将前台yyyy-MM-dd字符串转成日期对象
	@Past(message = "入职日期必须是一个过去的时间！")
	private Date hireDate;//表示入职日期
	@NotNull(message = "员工工资不能为空！")
	@Min(value = 2000,message = "员工工资不能低于2000元！")
	private Integer salary;//表示员工的工资
	private Department dept;//表示该员工所属的部门
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	
}
