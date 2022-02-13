package testing.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import kbh.regionmodeledit.com.CommonMethodsTest2;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetAllDataFromCSV {
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@Test
  public void exportContent_TC_DSMod_09() throws InterruptedException, FileNotFoundException, IOException {
	Reporter.log("TestCase: Get all data from csv file");	
	String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv.";
	BufferedReader reader = null;
	String line = "";
	reader = new BufferedReader(new FileReader(file));
	while((line = reader.readLine()) != null){
		// Prints the entire data from csv file
		System.out.println(line);
	}
  }
}	






