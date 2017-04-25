package com.packt.siuo.domain;

import java.io.File;
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
	private String baseClassName;
	private Date date;
	private Date usedTime;
	private int usedMemory;
	private String judgeResult;
	private String compilerLog;
	private String executionLog;
	private String fName;
	private String path;
	Logger logger = Logger.getLogger(this.getClass());
	
	public String getAnswerId(){
		return answerId;
	}
	public void setAnswerId(){
		this.answerId=userId+exerciseId;
		
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
	public void setJudgeResult(String judgeResult){
		this.judgeResult = judgeResult;
	}
	public void setCompilerLog(String compilerLog){
		this.compilerLog = compilerLog;
	}	
	public String getCompilerLog(){
		return compilerLog;
	}
	public void setExecutionLog(String executionLog){
		this.executionLog = executionLog;
	}	
	public String getExecutionLog(){
		return executionLog;
	}	
	public String getfName(){
		return fName;
	}
	public void setfName(){
		this.fName = baseClassName+ ".java";		
	}
	public String getBaseClassName(){
		return baseClassName;
	}
	public void setBaseClassName(String baseClassName){
		this.baseClassName = baseClassName;		
	}
	public String getPath(){
		return path;
	}
	public void setPath(){
		this.path = "C://siuo//answers//"+userId+"//"+exerciseId+"//";
		File file = new File(path+"a.txt");
		file.getParentFile().mkdirs();
		logger.info("utworzylem sciezkê: " +path);
	}
	public Answer(){
		super();
		setDate();
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
	}
	
	public Answer(String exerciseId, String userId, String language, String code) {
		this.exerciseId = exerciseId;
		this.userId = userId;
		this.language = language;
		this.code = code;
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
