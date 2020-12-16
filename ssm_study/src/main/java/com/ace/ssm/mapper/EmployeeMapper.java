package com.ace.ssm.mapper;
import java.util.List;

import com.ace.ssm.domain.Employee;
public interface EmployeeMapper {

	public List<Employee> findAll();
	
	public void addEmp(Employee emp);
	
	public Employee findById(String empId);
	
	public List<Employee> findByDeptId(String id);
	
	public void updateEmp(Employee emp);
	
	public void deleteById(String id);
	
	
}
