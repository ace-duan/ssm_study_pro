package com.ace.ssm.service;

import java.util.List;

import com.ace.ssm.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAllUsers();
	
	public void addEmployee(Employee emp);
	
	public Employee findEmpByEmpId(String empId);

	public void updateEmp(Employee emp);
	
	public void deleteEmpById(String empId);
}
