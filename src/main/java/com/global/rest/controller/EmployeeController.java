package com.global.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.rest.exception.DataNotFoundException;
import com.global.rest.exception.EmployeeNotFoundException;
import com.global.rest.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired 
	EmployeeService employeeService;
	
	@ApiOperation(value = "View a list of employees",response = Iterable.class)
	@GetMapping(value="/employees")
	public List<Employee> getEmployees(){
		
		List<Employee> employee = employeeService.getEmployeeList();
		if(CollectionUtils.isEmpty(employee)) {
			 throw new DataNotFoundException();
		}
		
		return employee;
		
	}
	
	@ApiOperation(value = "Search an employee with an ID",response = Employee.class)
	@GetMapping(value = "/employee")
	public ResponseEntity<Employee> getEmployee( @RequestParam(value="id",required =false)Integer id,Employee employee) {
	
		if(employee.getId()!=0) {
	Optional<Employee> employee1 =employeeService.getEmployee(id);
		
		return new ResponseEntity(employee1,HttpStatus.OK);
	}else {
		throw new EmployeeNotFoundException("id"+id);
	}}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		if (employee != null) {
			employeeService.save(employee);
			logger.info("Data saved successfully!!!!");
		} else {
			throw new DataNotFoundException();
		}
		return new ResponseEntity<Employee>(HttpStatus.OK);

	}

	
	
}
