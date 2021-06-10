package com.department.service;

import com.department.dto.DepartmentDTO;

public interface DepartmentService {

	public abstract DepartmentDTO addDepartment(DepartmentDTO departmentDto);

	public abstract DepartmentDTO getDeptByEmpId(long empId);
}
