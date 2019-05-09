package com.global.rest.service;

import java.util.List;

import com.global.rest.controller.Person;

public interface PersonService {

	List<Person> getPersonList();

	Person savePerson(Person person);

}
