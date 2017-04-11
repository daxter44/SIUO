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
		Exercise zadanie1 = new Exercise("Z1", "Zadanie Probne", "Java", "Algorytmy i struktury danych","Napisa� program do dodawania dw�ch liczb ca�kowitych. Na wej�ciu podane s� w oddzielnych liniach dwie liczby naturalne A oraz B mniejsze od 200. Na wyj�ciu nale�y wypisa� warto�� ich sumy, A + B.");
		zadanie1.setDificulty("�atwe");
		Exercise zadanie2 = new Exercise("Z2", "Liczby Pierwsze", "C", "Algorytmy i struktury danych","Sprawd�, kt�re spo�r�d danych liczb s� liczbami pierwszymi" );
		zadanie2.setDificulty("�atwe");
		Exercise zadanie3 = new Exercise("Z3", "TEST 3", "Java, C++", "Programowanie1", "Przepisz dane z wej�cia na wyj�cie. Dane wej�ciowe s� dwucyfrowymi liczbami naturalnymi. Zako�cz dzia�anie programu, gdy na wej�ciu pojawi si�, trzecia liczba 42 poprzedzona jak�kolwiek inn� liczb�, r�n� od 42.");
		zadanie3.setDificulty("�rednie");
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
