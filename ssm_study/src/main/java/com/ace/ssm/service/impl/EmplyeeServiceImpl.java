package com.ace.ssm.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ace.ssm.domain.Employee;
import com.ace.ssm.mapper.EmployeeMapper;
import com.ace.ssm.service.EmployeeService;

@Service("employeeService")
public class EmplyeeServiceImpl implements EmployeeService {
     
	@Autowired
	private EmployeeMapper empMapper;
	
	public List<Employee> findAllUsers() {
		// TODO Auto-generated method stub
		return empMapper.findAll();
	}

	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {Exception.class})
	public void addEmployee(Employee emp) {
		empMapper.addEmp(emp);
		
	}

	public Employee findEmpByEmpId(String empId) {
		// TODO Auto-generated method stub
		return empMapper.findById(empId);
	}

	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {SQLException.class})
	public void updateEmp(Employee emp) {
		empMapper.updateEmp(emp);
		
	}
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = {SQLException.class})
	public void deleteEmpById(String empId) {
		empMapper.deleteById(empId);
		
	}

	
}
