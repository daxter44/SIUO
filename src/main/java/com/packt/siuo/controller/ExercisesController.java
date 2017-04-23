package com.packt.siuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.packt.siuo.domain.Answer;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.service.AnswerService;
import com.packt.siuo.service.ExerciseService;
import com.packt.siuo.exception.*;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {

    Logger logger = Logger.getLogger(this.getClass());
 
@Autowired
@Qualifier("exerciseService")
private ExerciseService exerciseService;
	
@Autowired
@Qualifier("answerService")
private AnswerService answerService;

private static String UPLOADED_FOLDER = "F://temp//";
	
	
@RequestMapping
public String list(Model model) {
	model.addAttribute("exercise", exerciseService.getAllExercises());
	return "exercises";
}

@RequestMapping("/all")
public String allExercise(Model model) {
	model.addAttribute("exercise", exerciseService.getAllExercises());
	return "exercises";
}

@RequestMapping("/{course}")
public String getExerciseByCourse(Model model, @PathVariable("course") String course) {
	List<Exercise> exercises= exerciseService.getExerciseByCourse(course);
	if(exercises == null || exercises.isEmpty()){
		throw new NoExercisesFoundUnderCourseException();
	}
	model.addAttribute("exercise", exercises);
	return "exercises";
}
@RequestMapping("/filter/{ByCriteria}")
public String getExerciseByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams, Model model) {
	model.addAttribute("exercise", exerciseService.getExerciseByFilter(filterParams));
	return "exercises";
}
@RequestMapping("/exercise")
public String getExerciseById(@RequestParam("id") String exerciseId, Model model) {
	model.addAttribute("exercise", exerciseService.getExerciseById(exerciseId));
	return "exercise";
}
@InitBinder
public void initialiseBinder(WebDataBinder binder){
	binder.setDisallowedFields("");
}

@RequestMapping(value="/add", method = RequestMethod.GET)
public String getAddNewExerciseForm(Model model){
	Exercise newExercise = new Exercise();
	model.addAttribute("newExercise", newExercise);
	return "addExercise";
}


@RequestMapping(value="/add", method = RequestMethod.POST)
public String processAddNewExerciseForm(@ModelAttribute("newExercise") @Valid Exercise newExercise, BindingResult result) {
	String[] suppressedFields = result.getSuppressedFields();
	if(suppressedFields.length > 0){
		throw new RuntimeException("Próba wi¹zania bla ... blaaa... blaa");
	}
	if(result.hasErrors()){
		return "addExercise";
	}
	exerciseService.addExercise(newExercise);
	return "redirect:/exercises";
}
@RequestMapping(value="/createAnswer", method = RequestMethod.GET)
public String getCreateNewAnswer(@RequestParam("id") String exerciseId, Model model){
	//String userId = "U1";	
	model.addAttribute("exercise", exerciseService.getExerciseById(exerciseId));
	Answer newAnswer = new Answer();
	model.addAttribute("newAnswer", newAnswer);
	return "addAnswer";
}


@RequestMapping(value="/createAnswer", method = RequestMethod.POST)
public String processCreateNewAnswer(@RequestParam("id") String exerciseId, @ModelAttribute("newAnswer") @Valid Answer newAnswer , BindingResult result, Model model) {
	//model.addAttribute("addAnswer", exerciseService.getExerciseById(exerciseId));
	String userId ="U1";
	//newAnswer.setUserId(userId);
	//newAnswer.setExerciseId(exerciseId);
	String[] suppressedFields = result.getSuppressedFields();
	if(suppressedFields.length > 0){
		throw new RuntimeException("Próba wi¹zania niedozwolonych pól:" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
	}
	if(result.hasErrors()){
		return "addAnswer";
	}
	
	logger.info("kod :" + newAnswer.getCode()+ "jezeli nic nie ma to null");
	newAnswer.setExerciseId(exerciseId);
	newAnswer.setUserId(userId);
	answerService.addAnswer(newAnswer);
	logger.info("kod :" + newAnswer.getCode()+ "wykonalem service");
	
	return "redirect:/exercises";
}
@ExceptionHandler(ExerciseNotFoundException.class)
public ModelAndView handleError(HttpServletRequest req, ExerciseNotFoundException exception) {
	ModelAndView mav = new ModelAndView();
	mav.addObject("invalidExceptionId", exception.getExerciseId());
	mav.addObject("exception", exception);
	mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
	mav.setViewName("exerciseNotFound");
	return mav;
}
}



