package com.codingdojo.beltexam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexam.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
	
	@Query(value="SELECT * FROM tasks ORDER BY Priority ASC", nativeQuery=true)
	List<Task> findAllPriorityLowToHigh(); 
	@Query(value="SELECT * FROM tasks ORDER BY Priority DESC", nativeQuery=true)
	List<Task> findAllPriorityHighToLow(); 
}
