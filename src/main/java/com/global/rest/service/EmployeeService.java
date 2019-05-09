package com.global.rest.service;

import java.util.List;
import java.util.Optional;

import com.global.rest.controller.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeList();

	void save(Employee employee);

	Optional<Employee> getEmployee(Integer id);

	

}
