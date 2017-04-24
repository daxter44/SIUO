package com.packt.siuo.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.packt.siuo.checker.Compiler;
import com.packt.siuo.checker.Execution;
import com.packt.siuo.checker.MakeTextFile;
import com.packt.siuo.checker.Match;
import com.packt.siuo.domain.Answer;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.User;
import com.packt.siuo.domain.repository.AnswerRepository;
import com.packt.siuo.domain.repository.ExerciseRepository;
import com.packt.siuo.service.AnswerService;

@Service
@Qualifier("answerService")
public class AnswerServiceImpl implements AnswerService {
	
	@Resource
	AnswerRepository answerRepository;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	
	public void addAnswer(Answer answer){
		
		
		answerRepository.addAnswer(answer);
		answer.setfName();
		answer.setPath();
		MakeTextFile makeTextFile = new MakeTextFile(answer.getPath(), answer.getfName());
		makeTextFile.WriteFile(answer.getCode());
		Compiler compiler = new Compiler(answer.getPath(), answer.getfName());
		compiler.compile();
		Execution execution = new Execution();
		String werdykt = execution.execute("java", 1000 , answer.getPath(), answer.getBaseClassName());
		Match match = new Match();
		String werdykt2 = match.match(answer.getExerciseId(), answer.getUserId(), answer.getPath());
		logger.info(werdykt);
		logger.info(werdykt2);
		answer.setJudgeResult(werdykt2);
		answerRepository.addAnswer(answer);
	}
	
	
	
	
	
	
	


}
