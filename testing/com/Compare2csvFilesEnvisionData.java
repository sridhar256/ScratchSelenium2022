package testing.com;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Compare2csvFilesEnvisionData {
	
	@Test
	public void test() throws FileNotFoundException, IOException {
		
		String file1 = "C:\\Users\\Sreedhar\\Downloads\\envision.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv";
		
		HashSet<String> f1 = new HashSet<String>(FileUtils.readLines(new File(file1)));
		HashSet<String> f2 = new HashSet<String>(FileUtils.readLines(new File(file2)));
		
		f1.removeAll(f2);
		System.out.println(f1.toString());
		String value = f1.toString();
		boolean result = f1.equals(f2);
		System.out.println(result);
		
		if(result==true) {
			Reporter.log("Data is same");	
		} else {
			Reporter.log("Data is not the same");	
		}
		if(value!=null) {
			Reporter.log(value);	
		}
	}
		
	}
