package com.project.Lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Lookify.models.song;

@Repository
public interface SongsReopsitory extends CrudRepository<song, Long> {
	
	List<Song>

}
