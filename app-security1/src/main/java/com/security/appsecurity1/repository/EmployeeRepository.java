package com.security.appsecurity1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.security.appsecurity1.entity.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
