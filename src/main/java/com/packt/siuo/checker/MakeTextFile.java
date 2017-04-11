package com.packt.siuo.checker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class MakeTextFile
{
	
	 

	
	    private HttpServletRequest request;
	    Logger logger = Logger.getLogger(this.getClass());
	 
	 
	 int i;
	    FileInputStream fin;
	    String path = "";
	    String fName ="";
	    //String filePath = request.getRealPath("/");
	    


	    public MakeTextFile(String userId, String exerciseId, String code, String language) 
	    {
	        path = "C://exercises//";
	        fName = "a"+ userId + "e"+ exerciseId+ ".java";
	        logger.info("im here");
	        WriteFile(code);
	      
	    }
	    
	    public void WriteFile(String code) 
	    {
	    	logger.info("im here 2 ");
	    	BufferedWriter f = null;
	        try {
	            f = new BufferedWriter(new FileWriter("C://exercises//" + "a.txt"));
	            f.write("haha");
	            f.close();  
	           // logger.info("utworzy³em plik: "+ code);
	        }catch(IOException e) {
	            System.out.println(e);
	        }
	       
	}
}
