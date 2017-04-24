package com.packt.siuo.checker;

import java.io.FileInputStream;
import java.io.IOException;

public class Match {
	 int i=0, j=0;
	    int count = 0;

	    public String match (String exerciseId, String userId, String path) {
	        try (FileInputStream f1 = new FileInputStream("C:\\siuo\\answers\\"+userId+"\\"+exerciseId+"\\out.txt");
	             FileInputStream f2 = new FileInputStream("C:\\siuo\\exercises\\"+exerciseId+"\\key.txt")) {
	            do {
	                i = f1.read();
	                j = f2.read();
	                count++;

	                if (i != j) {
	                    System.out.println("Pliki roznia sie literami: " + (char) i + " i " + (char) j + " na pozycji: " + count);
	                    break;
	                }
	            } while (i != -1 && j != -1);

	            if (i != j) return Verdict.NOT_CORRECT;
	            else return Verdict.CORRECT;

	        } catch (IOException exc) {
	           return Verdict.IOERROR;
	        }
	    }
}
