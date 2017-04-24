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
	Logger logger = Logger.getLogger(this.getClass());
	 
	
	 int i;
	    FileInputStream fin;
	    String path = "";
	    String fName ="";
	    //String filePath = request.getRealPath("/");
	    


	    public MakeTextFile(String path, String fName) 
	    {
	        this.path = path;
	        this.fName = fName;	      
	    }
	    
	    public void WriteFile(String code) 
	    {
	    	BufferedWriter f = null;
	        try {
	            f = new BufferedWriter(new FileWriter(path + fName));
	            f.write(code);
	            f.close();  
	            logger.info("utworzy³em plik: "+ fName + "w lokalizacji: "+ path);
	         
	        }catch(IOException e) {
	            System.out.println(e);
	           
	        }
	       
	}
}
