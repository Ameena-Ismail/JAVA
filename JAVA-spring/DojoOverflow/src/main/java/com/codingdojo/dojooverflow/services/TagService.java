package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepo;

@Service
public class TagService {
	private final TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public ArrayList<Tag> findAllTags() {
		return (ArrayList<Tag>) tagRepo.findAll();
	}

	public Tag createTag(String tag) {
//		return tagRepo.save(tag);
		return tagRepo.save(new Tag(tag));
		
	}
}
