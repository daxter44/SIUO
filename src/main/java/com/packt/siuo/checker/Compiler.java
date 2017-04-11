package com.packt.siuo.checker;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.packt.siuo.checker.Verdict;

public class Compiler {
	String fName;
	
	public Compiler(String userId, String exerciseId){
		
		 fName = "u"+ userId + "e"+ exerciseId+ ".java";
		
	}
	
	public String compile( String path, String fName) {
        System.out.println("Code compilation started...");
        ProcessBuilder p;
        boolean compiled = true;

            p = new ProcessBuilder("javac", fName +".java");

        p.directory(new File(path));
        p.redirectErrorStream(true);

        try {
            Process pp = p.start();
            InputStream is = pp.getInputStream();
            String temp;
            try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
                while ((temp = b.readLine()) != null) {
                    compiled = false;
                    System.out.println(temp);
                }
                pp.waitFor();
            }

            if (!compiled) {
                is.close();
                return Verdict.COMPILE_ERROR;
            }
            is.close();
            return Verdict.COMPILE_SUCCESS;

        } catch (IOException | InterruptedException e) {
            System.out.println("in compile() " + e);
        }
        return Verdict.COMPILE_ERROR;
    }

}
