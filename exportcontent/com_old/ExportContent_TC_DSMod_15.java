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

public class ExportContent_TC_DSMod_15 {

	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;

	@Test (priority=1)
	public void ExportContent_TC_DSMod_15_CopyFiles() throws IOException { 

		File srcFile2 = new File("C:\\Users\\Sreedhar\\Downloads\\envision.csv");
		File destFile2 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv");
		FileUtils.copyFile(srcFile2, destFile2);
		Reporter.log("<font color='Lime'>File(envision.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
	}

	@Test (priority=2)
	public void ExportContent_TC_DSMod_15_Data() throws FileNotFoundException, IOException {   

		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv.";
		BufferedReader reader = null;

		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(envision.csv) data added to emailable report with PASS Status.</font>");

		for (String line = br.readLine(); 
				line != null; 
				line = br.readLine()) {
			Reporter.log(line);	
		}
		br.close();
	}


	@Test (priority=3)
	public void exportContent_TC_DSMod_15() throws InterruptedException, FileNotFoundException, IOException {

		Reporter.log("TestCase(TC_DSMod_15): Observe the columns presented in the Envision Links csv.");	
		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv";

		BufferedReader reader = null;
		String line = "";

		try {
			tcData = CommonMethodsTest2.readDataFromTC("tc1");
			reader = new BufferedReader(new FileReader(file));
			String a[]=reader.readLine().split(",");		
			String column1csv = a[0].toString();
			// System.out.println(column1csv);
			String column1 = tcData.get("Label43");
			// System.out.println(column1);
			if (column1csv.equals(column1)) {
				Reporter.log("<font color='Lime'>Column header1 in envision.csv file is same as 'ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header1 in envision.csv file is not same as 'ID' with FAIL Status.</font>");
			}

			String column2csv = a[1].toString();
			// System.out.println(column2csv);
			String column2 = tcData.get("Label44");
			// System.out.println(column2);
			if (column2csv.equals(column2)) {
				Reporter.log("<font color='Lime'>Column header2 in envision.csv file is same as 'Content GUID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header2 in envision.csv file is not same as 'Content GUID' with FAIL Status.</font>");
			}

			String column3csv = a[2].toString();
			// System.out.println(column3csv);
			String column3 = tcData.get("Label45");
			// System.out.println(column3);
			if (column3csv.equals(column3)) {
				Reporter.log("<font color='Lime'>Column header3 in envision.csv file is same as 'xID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header3 in envision.csv file is not same as 'xID' with FAIL Status.</font>");
			}

			String column4csv = a[3].toString();
			// System.out.println(column4csv);
			String column4 = tcData.get("Label46");
			// System.out.println(column4);
			if (column4csv.equals(column4)) {
				Reporter.log("<font color='Lime'>Column header4 in envision.csv file is same as 'URL' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header4 in envision.csv file is not same as 'URL' with FAIL Status.</font>");
			}

			String column5csv = a[4].toString();
			// System.out.println(column5csv);
			String column5 = tcData.get("Label47");
			// System.out.println(column5);
			if (column5csv.equals(column5)) {
				Reporter.log("<font color='Lime'>Column header5 in envision.csv file is same as 'Community Name' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header5 in envision.csv file is not same as 'Community Name' with FAIL Status.</font>");
			}

			String column6csv = a[5].toString();
			// System.out.println(column6csv);
			String column6 = tcData.get("Label48");
			// System.out.println(column6);
			if (column6csv.equals(column6)) {
				Reporter.log("<font color='Lime'>Column header6 in envision.csv file is same as 'Title' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header6 in envision.csv file is not same as 'Title' with FAIL Status.</font>");
			}

			String column7csv = a[6].toString();
			// System.out.println(column7csv);
			String column7 = tcData.get("Label49");
			// System.out.println(column7);
			if (column7csv.equals(column7)) {
				Reporter.log("<font color='Lime'>Column header7 in envision.csv file is same as 'Floor Plan ID' with PASS Status.</font>");	

			} else {
				Reporter.log("<font color='red'>Column header7 in envision.csv file is not same as 'Floor Plan ID' with FAIL Status.</font>");
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




