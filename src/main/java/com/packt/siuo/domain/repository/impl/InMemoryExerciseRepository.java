package com.packt.siuo.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.packt.siuo.domain.Exercise;
import com.packt.siuo.domain.repository.ExerciseRepository;
import com.packt.siuo.exception.ExerciseNotFoundException;

@Repository
public class InMemoryExerciseRepository implements ExerciseRepository {

	private List<Exercise> listOfExercises = new ArrayList<Exercise>();
	
	public InMemoryExerciseRepository() {
		Exercise zadanie1 = new Exercise("Z1", "Zadanie Probne", "Java", "Algorytmy i struktury danych","Napisaæ program do dodawania dwóch liczb ca³kowitych. Na wejœciu podane s¹ w oddzielnych liniach dwie liczby naturalne A oraz B mniejsze od 200. Na wyjœciu nale¿y wypisaæ wartoœæ ich sumy, A + B.");
		zadanie1.setDificulty("£atwe");
		Exercise zadanie2 = new Exercise("Z2", "Liczby Pierwsze", "C", "Algorytmy i struktury danych","SprawdŸ, które spoœród danych liczb s¹ liczbami pierwszymi" );
		zadanie2.setDificulty("£atwe");
		Exercise zadanie3 = new Exercise("Z3", "TEST 3", "Java, C++", "Programowanie1", "Przepisz dane z wejœcia na wyjœcie. Dane wejœciowe s¹ dwucyfrowymi liczbami naturalnymi. Zakoñcz dzia³anie programu, gdy na wejœciu pojawi siê, trzecia liczba 42 poprzedzona jak¹kolwiek inn¹ liczb¹, ró¿n¹ od 42.");
		zadanie3.setDificulty("Œrednie");
		listOfExercises.add(zadanie1);
		listOfExercises.add(zadanie2);
		listOfExercises.add(zadanie3);
	}
	
	public Exercise getExerciseById(String exerciseId) {
		Exercise exerciseById = null;
		for(Exercise exercise : listOfExercises){
			if(exercise!=null && exercise.getExerciseId()!=null && exercise.getExerciseId().equals(exerciseId)){
				exerciseById = exercise;
				break;
			}
		}
		if(exerciseById == null) {
			throw new ExerciseNotFoundException(exerciseId);
		}
		return exerciseById;
	}
	
	public List<Exercise> getExerciseByCourse(String course){
		List<Exercise> exerciseByCourse = new ArrayList<Exercise>();
		for(Exercise exercise: listOfExercises){
			if(course.equalsIgnoreCase(exercise.getCourse())) {
				exerciseByCourse.add(exercise);
			}
		}
		return exerciseByCourse;
	}
	public Set<Exercise> getExerciseByFilter(Map<String, List<String>> filterParams){
		Set<Exercise> exerciseByLanguage = new HashSet<Exercise>();
		Set<Exercise> exerciseByCourse = new HashSet<Exercise>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("language")) {
			for(String languageName: filterParams.get("language"))
			{
				for(Exercise exercise: listOfExercises){
					if(languageName.equalsIgnoreCase(exercise.getLanguage())){
						exerciseByLanguage.add(exercise);
					}
				}
			}
		}
		if(criterias.contains("course")) {
			for(String course: filterParams.get("course"))
			{
				exerciseByCourse.addAll(this.getExerciseByCourse(course));
			}
		}
		exerciseByCourse.retainAll(exerciseByLanguage);
		return exerciseByCourse;
	}
	public void addExercise(Exercise exercise){
		listOfExercises.add(exercise);
	}
	
	public List<Exercise>  getAllExercises(){
		return listOfExercises;
	}
}
