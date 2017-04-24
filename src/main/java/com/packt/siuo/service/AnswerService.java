package com.packt.siuo.service;

import com.packt.siuo.domain.Answer;

public interface AnswerService {

	void addAnswer(Answer newAnswer);
	public Answer getAnswerById(String answerId);

}
