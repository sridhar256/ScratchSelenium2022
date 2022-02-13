package kbh.exportcontent.com_old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import kbh.regionmodeledit.com.CommonMethodsTest2;

import org.apache.commons.io.FileUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExportContent_TC_DSMod_13 {

	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;

	@Test (priority=1)
	public void ExportContent_TC_DSMod_13_CopyFiles() throws IOException { 
		File srcFile3 = new File("C:\\Users\\Sreedhar\\Downloads\\escinfo.csv");
		File destFile3 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv");
		FileUtils.copyFile(srcFile3, destFile3);
		Reporter.log("<font color='Lime'>File(escinfo.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
	}	

	@Test (priority=2)
	public void ExportContent_TC_DSMod_13_Data() throws FileNotFoundException, IOException {  
		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv.";
		BufferedReader reader = null;
		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(escinfo.csv) data added to emailable report with PASS Status.</font>");
		for (String line = br.readLine(); 
				line != null; 
				line = br.readLine()) {
			Reporter.log(line);	
		}
		br.close();
	}

	@Test (priority=3)	
	public void exportContent_TC_DSMod_13() throws InterruptedException, FileNotFoundException, IOException {

		Reporter.log("TestCase(TC_DSMod_13): Observe the columns presented in the ESC Info csv.");	

		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv";

		BufferedReader reader = null;
		String line = "";

		try {
			tcData = CommonMethodsTest2.readDataFromTC("tc1");
			reader = new BufferedReader(new FileReader(file));
			String a[]=reader.readLine().split(",");		

			String column1csv = a[0].toString();
			// System.out.println(column1csv);
			String column1 = tcData.get("Label33");
			// System.out.println(column1);
			if (column1csv.equals(column1)) {
				Reporter.log("<font color='Lime'>Column header1 in escinfo.csv file is same as 'ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header1 in escinfo.csv file is not same as 'ID' with FAIL Status.</font>");
			}

			String column2csv = a[1].toString();
			// System.out.println(column2csv);
			String column2 = tcData.get("Label34");
			// System.out.println(column2);
			if (column2csv.equals(column2)) {
				Reporter.log("<font color='Lime'>Column header2 in escinfo.csv file is same as 'Content GUID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header2 in escinfo.csv file is not same as 'Content GUID' with FAIL Status.</font>");
			}

			String column3csv = a[2].toString();
			// System.out.println(column3csv);
			String column3 = tcData.get("Label35");
			// System.out.println(column3);
			if (column3csv.equals(column3)) {
				Reporter.log("<font color='Lime'>Column header3 in escinfo.csv file is same as 'xID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header3 in escinfo.csv file is not same as 'xID' with FAIL Status.</font>");
			}

			String column4csv = a[3].toString();
			// System.out.println(column4csv);
			String column4 = tcData.get("Label36");
			// System.out.println(column4);
			if (column4csv.equals(column4)) {
				Reporter.log("<font color='Lime'>Column header4 in escinfo.csv file is same as 'Template' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header4 in escinfo.csv file is not same as 'Template' with FAIL Status.</font>");
			}

			String column5csv = a[4].toString();
			// System.out.println(column5csv);
			String column5 = tcData.get("Label37");
			// System.out.println(column5);
			if (column5csv.equals(column5)) {
				Reporter.log("<font color='Lime'>Column header5 in escinfo.csv file is same as 'Energy Cost' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header5 in escinfo.csv file is not same as 'Energy Cost' with FAIL Status.</font>");
			}

			String column6csv = a[5].toString();
			// System.out.println(column6csv);
			String column6 = tcData.get("Label38");
			// System.out.println(column6);
			if (column6csv.equals(column6)) {
				Reporter.log("<font color='Lime'>Column header6 in escinfo.csv file is same as 'Resale Cost' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header6 in escinfo.csv file is not same as 'Resale Cost' with FAIL Status.</font>");
			}

			String column7csv = a[6].toString();
			// System.out.println(column7csv);
			String column7 = tcData.get("Label39");
			// System.out.println(column7);
			if (column7csv.equals(column7)) {
				Reporter.log("<font color='Lime'>Column header7 in escinfo.csv file is same as 'EDR/Title' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header7 in escinfo.csv file is not same as 'EDR/Title' with FAIL Status.</font>");
			}

			String column8csv = a[7].toString();
			// System.out.println(column8csv);
			String column8 = tcData.get("Label40");
			// System.out.println(column8);
			if (column8csv.equals(column8)) {
				Reporter.log("<font color='Lime'>Column header8 in escinfo.csv file is same as 'Community Name' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header8 in escinfo.csv file is not same as 'Community Name' with FAIL Status.</font>");
			}

			String column9csv = a[8].toString();
			// System.out.println(column9csv);
			String column9 = tcData.get("Label41");
			// System.out.println(column9);
			if (column9csv.equals(column9)) {
				Reporter.log("<font color='Lime'>Column header9 in escinfo.csv file is same as 'Title' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header9 in escinfo.csv file is not same as 'Title' with FAIL Status.</font>");
			}

			String column10csv = a[9].toString();
			// System.out.println(column10csv);
			String column10 = tcData.get("Label42");
			// System.out.println(column10);
			if (column10csv.equals(column10)) {
				Reporter.log("<font color='Lime'>Column header10 in escinfo.csv file is same as 'Floor Plan ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header10 in escinfo.csv file is not same as 'Floor Plan ID' with FAIL Status.</font>");
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



