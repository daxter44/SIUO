package com.packt.siuo.exception;

public class ExerciseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -694354952032299587L;
	private String exerciseId;
	public ExerciseNotFoundException(String exerciseId){
		this.exerciseId = exerciseId;
	}
	public String getExerciseId(){
		return exerciseId;
	}
}
