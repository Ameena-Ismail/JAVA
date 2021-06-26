package com.codingdojo.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.Person;
import com.codingdojo.license.repositories.PersonRepository;

@Service
public class PersonService {
	//adding the person repository as dependency 
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;			
	}
	//create a person 
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	//find all 
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	//find user by id
	public Person findPerson(Long id) {
		Optional<Person> findPerson = personRepository.findById(id);
		if(findPerson.isPresent()) {
			System.out.println(findPerson.get());
			return findPerson.get();
		}else {
			return null;
		}
	}
}
