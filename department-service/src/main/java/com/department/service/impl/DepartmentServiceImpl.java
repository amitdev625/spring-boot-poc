package com.department.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.department.dto.DepartmentDTO;
import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentRepository departmentRepository;
	
   
    
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    	this.departmentRepository = departmentRepository;
    	
    }
    
	@Override
	public DepartmentDTO addDepartment(DepartmentDTO departmentDto) {
		ModelMapper modelMapper = new ModelMapper();
		Department newDepartment = modelMapper.map(departmentDto, Department.class);
		Department savedDept = departmentRepository.save(newDepartment);
		return modelMapper.map(savedDept, DepartmentDTO.class);
	}

	@Override
	public DepartmentDTO getDeptByEmpId(long empId) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.
				map(departmentRepository.findDepartmentByEmployeeId(empId),DepartmentDTO.class);
	}

}
