package com.packt.siuo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.siuo.domain.Exercise;

public interface ExerciseService {
	List<Exercise> getAllExercises();
	Exercise getExerciseById(String exerciseID);
	List<Exercise> getExerciseByCourse(String course);
	Set<Exercise> getExerciseByFilter(Map<String, List<String>> filterParams);
	void addExercise(Exercise exercise);
}
