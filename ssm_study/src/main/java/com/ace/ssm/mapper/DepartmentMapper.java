package com.ace.ssm.mapper;

import java.util.List;

import com.ace.ssm.domain.Department;

public interface DepartmentMapper {

	public List<Department> findAll();
	
	public Department findById(String id);
}
