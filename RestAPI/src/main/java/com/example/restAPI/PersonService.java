package com.example.restAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;


@Service
public class PersonService {
	
	
	private List<Person> personsList = new ArrayList<>(Arrays.asList(
			new Person("NAME", "AGE", "COMPANY", "COMPANYID"),
			new Person("Rupesh", "20", "Accolite", "101"),
			new Person("Sathvika", "22", "Amazon", "102")
		));
	
	public List<Person> getAllPersons() {
		return personsList;
	}
	
	public void addPerson(Person person) {
		personsList.add(person);
	}
	
	public void updatePerson(Person person, String companyId) {
		int count = 0;
		for(Person person1 : personsList) {
			if(person1.getCompanyId().equals(companyId)) {
				personsList.set(count, person);
			}
			count++;
		}
	}
	
	public void deletePerson(String id) {
		personsList.removeIf(person -> person.getCompanyId().equals(id));
	}
}
