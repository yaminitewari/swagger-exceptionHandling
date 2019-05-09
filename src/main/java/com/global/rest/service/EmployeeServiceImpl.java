package com.global.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.rest.controller.Employee;
import com.global.rest.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired 
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployeeList() {
		
		 List<Employee> employees = employeeDao.findAll();
		 return employees;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		return employeeDao.findById(id);
	}



}
