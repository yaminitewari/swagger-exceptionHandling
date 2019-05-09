package com.global.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.rest.controller.Person;
import com.global.rest.dao.PersonDao;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	public List<Person> getPersonList() {

		return personDao.findAll();
	}

	@Override
	public Person savePerson(Person person) {
       return personDao.save(person);	
	}

}
