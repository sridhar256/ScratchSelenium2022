package testing.com;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;

public class Compare2csvFilesEscInfoData {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		String file1 = "C:\\Users\\Sreedhar\\Downloads\\escinfo.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv";
		
		HashSet<String> f1 = new HashSet<String>(FileUtils.readLines(new File(file1)));
		HashSet<String> f2 = new HashSet<String>(FileUtils.readLines(new File(file2)));
		
		f1.removeAll(f2);
		System.out.println(f1.toString());
		System.out.println(f1.equals(f2));
		
		
	}
}