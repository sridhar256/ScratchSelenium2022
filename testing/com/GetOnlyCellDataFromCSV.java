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

public class GetOnlyCellDataFromCSV {
	
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@Test

public void exportContent_TC_DSMod_09() throws InterruptedException, FileNotFoundException, IOException {
	
	Reporter.log("TestCase(TC_DSMod_09): Observe the columns presented in the Floor Plan csv.");	
	String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv.";
	BufferedReader reader = null;
	String line = "";
	reader = new BufferedReader(new FileReader(file));
	int linecount=0;
	while((line = reader.readLine()) != null){
	linecount++;
	if(linecount==2){
	String[] cell= line.split(",");
	// prints the cell data
	System.out.println(cell[0]);
	
	}
	}
}
}






