package com.schintatkun.java2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schintatkun.java2.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{
	List<Idea> findAll();
	@Query(value="SELECT * FROM ideas ORDER BY liked_byusers ASC", nativeQuery=true)
	List<Idea> findAllLowToHigh(); 
}
