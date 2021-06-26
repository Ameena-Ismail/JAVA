package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.QuestionRepo;

@Service
public class QuestionService {
	private final QuestionRepo questionRepo;
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	//add new question
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}

	//find question by id
	public Question findQ(Long id) {
		Optional<Question> myQ = questionRepo.findById(id);
		if (myQ.isPresent()) {
			return myQ.get();
		}else {
			return null;
		}
	}
	//find all question
	public List<Question> findAll(){
		return questionRepo.findAll();
	}
}
