package com.global.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.rest.controller.Person;

@Repository
@Transactional
public interface PersonDao extends JpaRepository<Person, Integer>{

	
}
