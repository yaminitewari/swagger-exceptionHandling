package com.global.rest.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.rest.controller.Employee;

@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
