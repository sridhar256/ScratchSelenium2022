package testing.com;

import java.io.*;
import java.util.ArrayList;

public class Compare2csvFiles {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		String file1 = "C:\\Users\\Sreedhar\\Downloads\\envision.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv";

		BufferedReader br1=new BufferedReader(new FileReader(file1));
		BufferedReader br2=new BufferedReader(new FileReader(file2));
		String line1=null;
		String line2=null;
		String heading[]=br1.readLine().split(",");
		
		while((line1=br1.readLine())!=null && (line2=br2.readLine())!=null)  {
			String data1[]=line1.split(",");
			String data2[]=line2.split(",");
			
			if(!data1[0].equals(data2[0])){
				System.out.println(heading[0]+"   "+data1[0]);
			}
			else if(!data2[1].equals(data2[1])){
				System.out.println(heading[1]+"   "+data1[1]);	
			}
				else if(!data1[2].equals(data2[2])){
					System.out.println(heading[2]+"   "+data1[2]);	
			}
				else if(!data1[3].equals(data2[3])){
					System.out.println(heading[3]+"   "+data1[3]);	
			}
				else if(!data1[4].equals(data2[4])){
					System.out.println(heading[4]+"   "+data1[4]);	
			}
				else if(!data1[5].equals(data2[5])){
					System.out.println(heading[5]+"   "+data1[5]);	
			}
				else if(!data1[6].equals(data2[6])){
					System.out.println(heading[6]+"   "+data1[6]);	
			}
		}	
	}
}