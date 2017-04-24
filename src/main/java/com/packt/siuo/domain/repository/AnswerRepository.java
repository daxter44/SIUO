package com.packt.siuo.domain.repository;

import java.util.List;

import com.packt.siuo.domain.Answer;

public interface AnswerRepository {
	
	void addAnswer(Answer answer);
	List<Answer> getAllAnswers();

}
