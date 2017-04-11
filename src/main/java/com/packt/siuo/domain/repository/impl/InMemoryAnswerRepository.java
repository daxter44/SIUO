package com.packt.siuo.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.packt.siuo.domain.Answer;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.repository.AnswerRepository;

@Repository
@Qualifier("answerService")
public class InMemoryAnswerRepository implements AnswerRepository {
	
	private List<Answer> listOfAnswers = new ArrayList<Answer>();
	
	public void addAnswer(Answer answer){
		listOfAnswers.add(answer);
	}
}
