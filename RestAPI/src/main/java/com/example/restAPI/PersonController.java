package com.example.restAPI;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{
	
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(path="/", produces = "application/json")
	public List<Person> getPersons(){
		return personService.getAllPersons();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/addPerson")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/person/{companyId}")
	public void updatePerson(@RequestBody Person person, @PathVariable("companyId") String companyId) {
		personService.updatePerson(person, companyId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/person/{companyId}")
	public void deletePerson(@PathVariable("companyId") String companyId) {
		personService.deletePerson(companyId);
	}
	
	
	
	
	
}
