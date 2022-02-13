package testing.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

public class test {

	@Test
	public  void compare() throws IOException {
		String file1 = "C:\\Users\\Sreedhar\\Downloads\\envision.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv";
		String Line;
		String nLine;
		FileReader fr1 = new FileReader(file1);
		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		FileReader fr2 = new FileReader(file2);
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		HashMap<String, String> s1 = new HashMap();
		while ((Line = br1.readLine())!= null){
			s1.put(Line.substring(0, Line.indexOf(',')), Line);
			String[] names=Line.split(",");
			String names1=names[0];
			String output1=s1.get(names1);
			System.out.println(output1);
		}

		HashMap<String, String> s2 = new HashMap();
		while((nLine = br2.readLine())!= null){
			s2.put(nLine.substring(0, nLine.indexOf(',')), nLine);
			String[] ntid=nLine.split(",");
			String ntids=ntid[0];
			String output2=s2.get(ntids);
			System.out.println(output2);
		}

		HashSet<String> combineKeys = new HashSet<>(s1.keySet());
		combineKeys.addAll(s2.keySet());
		combineKeys.removeAll(s1.keySet());
		System.out.println(combineKeys);
		
	
	}
}