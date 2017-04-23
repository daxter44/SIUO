package com.packt.siuo.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.packt.siuo.checker.Compiler;
import com.packt.siuo.checker.MakeTextFile;
import com.packt.siuo.domain.Answer;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.User;
import com.packt.siuo.domain.repository.AnswerRepository;
import com.packt.siuo.domain.repository.ExerciseRepository;
import com.packt.siuo.service.AnswerService;

@Service
@Qualifier("answerService")
public class AnswerServiceImpl implements AnswerService {
	
	/*@Autowired*/
	@Resource
	AnswerRepository answerRepository;
	//ExerciseRepository exerciseRepository;
	Logger logger = Logger.getLogger(this.getClass());
	
	
	public void addAnswer(Answer answer){
		
		logger.info("kod :" + answer.getCode()+ "jezeli nic nie ma to null");
		answerRepository.addAnswer(answer);
		MakeTextFile makeTextFile = new MakeTextFile(answer.getUserId(), answer.getExerciseId(), answer.getCode(), answer.getLanguage());
		
		
		//answerRepository.addAnswer(answer);
	}
	
	
	
	
	/*public String createAnswer(String exerciseId, String userId, 
			String languageSlug, String code) {
		Exercise exercise = exerciseRepository.getExerciseById(exerciseId);
		//Language language = languageMapper.getLanguageUsingSlug(languageSlug);
		
		Answer answer = new Answer(exerciseId, userId, "java", code);
		Compile(userId, exerciseId, code, languageSlug);
		
		//@SuppressWarnings("unchecked")
		//	Map<String, Object> result = (Map<String, Object>) getSubmissionCreationResult(submission, isCsrfTokenValid);
		//boolean isSuccessful = (Boolean)result.get("isSuccessful");
		//if ( isSuccessful ) {
			/*submissionMapper.createSubmission(submission);
			
			long submissionId = submission.getSubmissionId();
			createSubmissionTask(submissionId);
			result.put("submissionId", submissionId);
		}
		return "sukces";
	}
	public boolean Compile(String userId, String exerciseId, String code, String language){
		try {
		MakeTextFile makeTextFile = new MakeTextFile(userId, exerciseId, code, language);
		Compiler c = new Compiler(userId, exerciseId);
		logger.info("Kompilowanie powiod³o siê");
		return true;
		}
		catch(Exception e){
			logger.info("Kompilowanie nie powiod³o siê ");
			return false;
		}
	}*/
	
	


}
