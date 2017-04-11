package com.packt.siuo.domain;

import java.util.Date;

import com.packt.siuo.checker.MakeTextFile;
import com.packt.siuo.checker.Compiler;

public class Answer {
	
	private String answerId;
	private String userId;
	private String exerciseId;
	private String language;
	private String code;
	private Date date;
	private Date usedTime;
	private int usedMemory;
	private String judgeResult;
	private String judgeLog;
	
	public String getAnswerId(){
		return answerId;
	}
	private void setAnswerId(String answerId){
		this.answerId = answerId;
	}
	public String getExerciseId(){
		return exerciseId;
	}
	private void setExerciseId(String exerciseId){
		this.exerciseId = exerciseId;
	}
	public String getUserId(){
		return userId;
	}
	private void setUserId(String userId){
		this.userId =  userId;
	}
	public String getLanguage(){
		return language;
	}
	private void setLanguage(String language){

		this.language = language;
	}
	public String getCode(){
		return code;
	}
	private void setCode(String code){
		this.code = code;
	}
	public Date getDate(){
		return date;
	}
	private void setDate(){
		date = new Date();
	}
	public Date getUsedTime(){
		return usedTime;
	}
	private void setUsedTime(Date usedTime){
		this.usedTime = usedTime;
	}
	public int getUsedMemory(){
		return usedMemory;
	}
	private void setUsedMemory(int usedMemory){
		this.usedMemory = usedMemory;
	}
	public String getJudgeResult(){
		return judgeResult;
	}
	private void setJudgeLog(String judgeLog){
		this.judgeLog = judgeLog;
	}	
	public String getJudgeLog(){
		return judgeLog;
	}
	private void setJudgeResult(String judgeResult){
		this.judgeResult = judgeResult;
	}
	public Answer (){
		super();
	}
	
	public Answer(String code){
		
		this.code=code;
		//setLanguage("java");
	}
	
	/*public Answer(String exerciseId, String userId,  String language, String code){
		//setAnswerId(answerId);
		setUserId(userId);
		setExerciseId(exerciseId);
		setLanguage(language);
		setCode(code);
	
		//c.compile();	
		 * 
		 * String exerciseId, String userId, 	
		 * 
		 * this.exerciseId=exerciseId;
		this.userId=userId;
	}*/
	@Override 
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerId == null) {
			if(other.answerId != null)
				return false;
		}
		else if (!answerId.equals(other.answerId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		return result;
			
		
	}
	
	
}
