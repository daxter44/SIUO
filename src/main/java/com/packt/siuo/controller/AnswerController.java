package com.packt.siuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.siuo.domain.repository.AnswerRepository;
@Controller
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository;
	
	@RequestMapping("/answers")
	public String list(Model model){
		model.addAttribute("answers", answerRepository.getAllAnswers());
		return "answers";
	}
}
