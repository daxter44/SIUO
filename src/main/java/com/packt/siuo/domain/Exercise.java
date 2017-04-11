package com.packt.siuo.domain;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Exercise {

	@Pattern(regexp="Z[0-9]+", message="{Pattern.Exercise.exerciseId.validation}")
	private String exerciseId;
	private String language;
	@Size(min=4, max=30, message="{Pattern.Exercise.name.validation}")
	private String name;
	private String description;
	private String in;
	private String out;
	private String example;
	private String course;
	private String dificulty;
	
	
	public Exercise() {
	super();	
	}
	
	public Exercise(String exerciseId, String name, String language, String course, String description){
		this.exerciseId = exerciseId;
		this.name = name;
		this.language = language;
		this.description = description;
		this.course = course;
	}
	
	public String getExerciseId(){
		return exerciseId;
	}
	public void setExerciseId(String e){
		exerciseId=e;
	}
	public String getName(){
		return name;
	}
	public void setName(String e){
		name=e;
	}
	public String getLanguage(){
		return language;
	}
	public void setLanguage(String e){
		language=e;
	}
	public String getDescription(){
		return description ;
	}
	public void setDescription(String e){
		description=e;
	}
	public String getIn(){
		return in;
	}
	public void setIn(String e){
		in=e;
	}
	public String getOut(){
		return out;
	}
	public void setOut(String e){
		out=e;
	}
	public String getExample(){
		return example;
	}
	public void setExample(String e){
		example=e;
	}
	public String getCourse(){
		return course;
	}
	public void setCourse(String e){
		course=e;
	}
	public String getDificulty(){
		return dificulty;
	}
	public void setDificulty(String e){
		dificulty=e;
	}
	
	
	@Override 
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (exerciseId == null) {
			if(other.exerciseId != null)
				return false;
		}
		else if (!exerciseId.equals(other.exerciseId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exerciseId == null) ? 0 : exerciseId.hashCode());
		return result;
			
		
	}
	
}
