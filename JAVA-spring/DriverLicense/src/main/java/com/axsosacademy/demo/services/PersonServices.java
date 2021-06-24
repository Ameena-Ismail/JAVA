package com.axsosacademy.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Person;
import com.axsosacademy.demo.repositories.PersonRepository;

@Service
public class PersonServices {

	private final PersonRepository personRepository;
	
	public PersonServices(PersonRepository personRepository) {
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