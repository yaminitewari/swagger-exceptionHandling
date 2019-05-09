package com.global.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.rest.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(value="/getPerson")
	public ResponseEntity<List<Person>> getPerson(){
		List<Person> personList=personService.getPersonList();
		return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
		
	}

	@PostMapping(value="/savePerson")
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		Person person2=personService.savePerson(person);
		return new ResponseEntity<Person>(person2,HttpStatus.OK);
	}
}
