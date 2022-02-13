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
import java.util.HashSet;

import kbh.regionmodeledit.com.CommonMethodsTest2;

import org.apache.commons.io.FileUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExportContent_TC_DSMod_09 {

	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;

	@Test (priority=1)
	public void ExportContent_TC_DSMod_09_CopyFiles() throws IOException { 

		File srcFile1 = new File("C:\\Users\\Sreedhar\\Downloads\\floorplan.csv");
		File destFile1 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv");
		FileUtils.copyFile(srcFile1, destFile1);
		Reporter.log("<font color='Lime'>File(floorplan.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
	}

	@Test (priority=2)
	public void ExportContent_TC_DSMod_11_GetTheData() throws FileNotFoundException, IOException {   

		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv.";
		BufferedReader reader = null;
		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(floorplan.csv) data added to emailable report with PASS Status.</font>");
		for (String line = br.readLine(); 
				line != null; 
				line = br.readLine()) {
			// Print entire data in csv file
			Reporter.log(line);	
			// Print only column wise data in csv file
			// String[] cell= line.split(",");
			// System.out.println(cell[0]);	
		}
		br.close();
	}

	@Test (priority=3)

	public void exportContent_TC_DSMod_09_CompareData() throws InterruptedException, FileNotFoundException, IOException {

		Reporter.log("TestCase(TC_DSMod_09): Observe the columns presented in the Floor Plan csv.");	

		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv.";

		BufferedReader reader = null;
		String line = "";

		try {
			tcData = CommonMethodsTest2.readDataFromTC("tc1");
			reader = new BufferedReader(new FileReader(file));
			String a[]=reader.readLine().split(",");		

			String column1csv = a[0].toString();
			// System.out.println(column1csv);
			String column1 = tcData.get("Label19");
			// System.out.println(column1);
			if (column1csv.equals(column1)) {
				Reporter.log("<font color='Lime'>Column header1 in floorplan.csv file is same as 'ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header1 in floorplan.csv file is not same as 'ID' with FAIL Status.</font>");	
			}

			String column2csv = a[1].toString();
			// System.out.println(column2csv);
			String column2 = tcData.get("Label20");
			// System.out.println(column2);
			if (column2csv.equals(column2)) {
				Reporter.log("<font color='Lime'>Column header2 in floorplan.csv file is same as 'Content GUID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header2 in floorplan.csv file is not same as 'Content GUID' with FAIL Status.</font>");
			}

			String column3csv = a[2].toString();
			// System.out.println(column3csv);
			String column3 = tcData.get("Label21");
			// System.out.println(column3);
			if (column3csv.equals(column3)) {
				Reporter.log("<font color='Lime'>Column header3 in floorplan.csv file is same as 'xID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header3 in floorplan.csv file is not same as 'xID' with FAIL Status.</font>");
			}

			String column4csv = a[3].toString();
			// System.out.println(column4csv);
			String column4 = tcData.get("Label22");
			// System.out.println(column4);
			if (column4csv.equals(column4)) {
				Reporter.log("<font color='Lime'>Column header4 in floorplan.csv file is same as 'Priced From' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header4 in floorplan.csv file is not same as 'Priced From' with FAIL Status.</font>");
			}

			String column5csv = a[4].toString();
			// System.out.println(column5csv);
			String column5 = tcData.get("Label23");
			// System.out.println(column5);
			if (column4csv.equals(column5)) {
				Reporter.log("<font color='Lime'>Column header5 in floorplan.csv file is same as 'Community Name' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header5 in floorplan.csv file is not same as 'Community Name' with FAIL Status.</font>");
			}

			String column6csv = a[5].toString();
			// System.out.println(column6csv);
			String column6 = tcData.get("Label24");
			// System.out.println(column6);
			if (column6csv.equals(column6)) {
				Reporter.log("<font color='Lime'>Column header6 in floorplan.csv file is same as 'Title' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header6 in floorplan.csv file is not same as 'Title' with FAIL Status.</font>");
			}

			String column7csv = a[6].toString();
			// System.out.println(column7csv);
			String column7 = tcData.get("Label25");
			// System.out.println(column7);
			if (column7csv.equals(column7)) {
				Reporter.log("<font color='Lime'>Column header7 in floorplan.csv file is same as 'Floor Plan ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header7 in floorplan.csv file is not same as 'Floor Plan ID' with FAIL Status.</font>");
			}
			while ((line=reader.readLine())!=null) {
				String[] row = line.split(",");
				for (String index: row){
				}
			}
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			reader.close();
		}
	}
}






