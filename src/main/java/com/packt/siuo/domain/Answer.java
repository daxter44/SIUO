package com.packt.siuo.domain;

import java.util.Date;

import org.apache.log4j.Logger;

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
	private String fName;
	private String path;
	Logger logger = Logger.getLogger(this.getClass());
	
	public String getAnswerId(){
		return answerId;
	}
	public void setAnswerId(String answerId){
		this.answerId = answerId;
	}
	public String getExerciseId(){
		return exerciseId;
	}
	public void setExerciseId(String exerciseId){
		this.exerciseId = exerciseId;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId =  userId;
	}
	public String getLanguage(){
		return language;
	}
	public void setLanguage(String language){

		this.language = language;
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(){
		date = new Date();
	}
	public Date getUsedTime(){
		return usedTime;
	}
	public void setUsedTime(Date usedTime){
		this.usedTime = usedTime;
	}
	public int getUsedMemory(){
		return usedMemory;
	}
	public void setUsedMemory(int usedMemory){
		this.usedMemory = usedMemory;
	}
	public String getJudgeResult(){
		return judgeResult;
	}
	public void setJudgeLog(String judgeLog){
		this.judgeLog = judgeLog;
	}	
	public String getJudgeLog(){
		return judgeLog;
	}
	public void setJudgeResult(String judgeResult){
		this.judgeResult = judgeResult;
	}
	public String getfName(){
		return fName;
	}
	public void setfName(){
		this.fName = "a"+ userId + "e"+ exerciseId+ ".java";		
	}
	public String getPath(){
		return path;
	}
	public void setPath(){
		this.path = "C://exercises//";
	}
	public Answer(){
		super();
		//logger.info("No czeœæ 2 ");
	}
	
	public Answer(String code){
		
		this.code=code;
		logger.info("No czeœæ 3 ");
		//setLanguage("java");
	}
	public Answer(String exerciseId, String userId) {
		this.exerciseId = exerciseId;
		this.userId = userId;
		logger.info("No czeœæ 1 ");
		
	}
	
	public Answer(String exerciseId, String userId, String language, String code) {
		this.exerciseId = exerciseId;
		this.userId = userId;
		this.language = language;
		this.code = code;
		logger.info("No czeœæ 4 ");
	}
	
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
