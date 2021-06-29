package com.Ameenaproject.eventsbeltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ameenaproject.eventsbeltreviewer.models.Event;



@Repository
public interface EventRepo extends CrudRepository <Event, Long> {

}
