package com.schintatkun.java2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.schintatkun.java2.models.Idea;
import com.schintatkun.java2.repositories.IdeaRepository;

@Service
public class IdeaService {
	private final IdeaRepository ideaRepo;
	
	public IdeaService(IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
	//find all
	public List<Idea> findAllIdea(){
		return ideaRepo.findAll();
	}
	//create idea
	public Idea createIdea(Idea idea) {
		return ideaRepo.save(idea);
	}
	//update idea
	public void updateIdea(Idea idea) {
		ideaRepo.save(idea);
	}
	//find by id
	public Idea findIdea(Long id) {
		Optional<Idea> myIdea = ideaRepo.findById(id);
		if (myIdea.isPresent()) {
			return myIdea.get();
		}else{
			return null;
		}
	}
	//Delete idea
	public void deleteIdea(Long id) {
		ideaRepo.deleteById(id);
	}
	//like Low to high
	public List<Idea> findLowHigh(){
		return ideaRepo.findAllLowToHigh();
	}
	
}
