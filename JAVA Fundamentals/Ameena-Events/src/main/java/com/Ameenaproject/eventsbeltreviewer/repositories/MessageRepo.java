package com.Ameenaproject.eventsbeltreviewer.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ameenaproject.eventsbeltreviewer.models.Message;


@Repository
public interface MessageRepo extends CrudRepository <Message, Long>{

}
