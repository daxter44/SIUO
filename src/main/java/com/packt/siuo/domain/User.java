package com.packt.siuo.domain;

public class User {
	
	private int userId;
	private String name;
	private String surname;
	private String course;
	private int year;
	private String noOfExercisesMade;
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
