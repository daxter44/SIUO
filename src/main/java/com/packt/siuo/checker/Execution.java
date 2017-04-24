package com.packt.siuo.checker;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Execution {
	 public String execute(String l, long timeInMillis, String path, String cName) {
	        System.out.println("Code started executing.");
	        ProcessBuilder p;

	            p = new ProcessBuilder("java", cName);

	        p.directory(new File(path));

	        p.redirectErrorStream(true);
	        System.out.println("Current directory " + System.getProperty("dir"));
	        File out = new File(path + "out.txt");

	        p.redirectOutput(out);
	        if(out.exists())
	            System.out.println("Output file generated " + out.getAbsolutePath());
	        try {

	            Process pp = p.start();
	            if (!pp.waitFor(timeInMillis, TimeUnit.MILLISECONDS)) {
	                return Verdict.TLE;
	            }
	            int exitCode = pp.exitValue();
	            System.out.println("Exit Value = " + pp.exitValue());
	            if(exitCode != 0)
	                return Verdict.RUN_ERROR;
	        } catch (IOException ioe) {
	            System.err.println("in execute() "+ioe);
	        } catch (InterruptedException ex) {
	            System.err.println(ex);
	        }
	        System.out.println("Code execution finished!");
	        //delete executables
	    //    deleteExecutables(l);
	        return Verdict.RUN_SUCCESS;
	    }
}
