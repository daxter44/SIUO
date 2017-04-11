package com.packt.siuo.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.siuo.domain.*;

public interface ExerciseRepository {

	List <Exercise> getAllExercises();
	Exercise getExerciseById(String exerciseId);
	List<Exercise> getExerciseByCourse(String course);
	Set<Exercise> getExerciseByFilter(Map<String, List<String>> filterParams);
	void addExercise(Exercise exercise);
}
