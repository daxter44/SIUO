package com.packt.siuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;  

import com.packt.siuo.domain.repository.AnswerRepository;
import com.packt.siuo.service.AnswerService;
@Controller

@RequestMapping("/answers")
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	@Qualifier("answerService")
	private AnswerService answerService;
	
	
	
	@RequestMapping
	public String list(Model model){
		model.addAttribute("answers", answerRepository.getAllAnswers());
		return "answers";
	}
	@RequestMapping("/answer")
	public String getAnswerById(@RequestParam("id") String answerId, Model model) {
		model.addAttribute("answer", answerService.getAnswerById(answerId));
		return "answer";
	}
}
