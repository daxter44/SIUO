package com.packt.siuo.domain;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class User {
	
	@Id
	private int userId;
	 @Column(name="name")
	private String name;
	 @Column(name="surname")
	private String surname;
	//@Column(name="course")
	private String course;
	//@Column(name="year")
	private int year;
	//@Column(name="no_of_exercises_made")
	private String noOfExercisesMade;
	//@Column(name="status")
	private String status;
	
	public User() {
		super();
	}
	public User(int userId, String name, String surname, String course, int year) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.course = course;
		this.year = year;
		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String e){
		name = e;
	}
	public String getSurname(){
		return surname;
	}
	public void setSurname(String e){
		surname = e;
		
	}
	public String getCourse(){
		return course;
	}
	public void setCourse(String e){
		course = e;
		
	}
	public int getYear(){
		return year;
	}
	public void setYear(int e){
		year = e;
		
	}
	

}
