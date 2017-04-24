package com.packt.siuo.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.packt.siuo.checker.MakeTextFile;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.repository.ExerciseRepository;
import com.packt.siuo.service.ExerciseService;

@Service
@Qualifier("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Exercise> getAllExercises(){
		return exerciseRepository.getAllExercises();
	}
	public Exercise getExerciseById(String exerciseId){
		return exerciseRepository.getExerciseById(exerciseId);
	}
	
	public List<Exercise> getExerciseByCourse(String course){
		return exerciseRepository.getExerciseByCourse(course);
	}
	public Set<Exercise> getExerciseByFilter(Map<String, List<String>> filterParams){
		return exerciseRepository.getExerciseByFilter(filterParams);
	}
	public void addExercise(Exercise exercise){
		String path = "C:\\siuo\\exercises\\"+exercise.getExerciseId()+"\\";	
		File file = new File(path+"a.txt");
		file.getParentFile().mkdirs();
		logger.info("utworzylem sciezkê: " +path);
		MakeTextFile maketextfile = new MakeTextFile(path, "key.txt");
		maketextfile.WriteFile(exercise.getOut());		
		exerciseRepository.addExercise(exercise);
	}
}
