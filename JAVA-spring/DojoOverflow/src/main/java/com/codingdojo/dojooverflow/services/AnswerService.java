package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	private final AnswerRepo answerRepo;
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}
	public Answer createAns(Answer answer) {
		return answerRepo.save(answer);
	}
	public List<Answer> getAll() {
		return answerRepo.findAll();
	}

}
