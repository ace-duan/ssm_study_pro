package com.ace.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.ssm.domain.Department;
import com.ace.ssm.mapper.DepartmentMapper;
@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentMapper deptMapper;
	
	public List<Department> getDepts(){
		
		return deptMapper.findAll();
	}
}
