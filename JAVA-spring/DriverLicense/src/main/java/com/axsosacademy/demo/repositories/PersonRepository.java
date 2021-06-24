package com.axsosacademy.demo.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
}