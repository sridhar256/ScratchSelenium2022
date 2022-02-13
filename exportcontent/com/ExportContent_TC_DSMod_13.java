package kbh.exportcontent.com;

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

import regression.com.ExtentReporManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportListener.ExtentReporterNGUpdated;

public class ExportContent_TC_DSMod_13 {

	CommonMethodsExportContent cm = new CommonMethodsExportContent();
	HashMap<String, String> tcData;
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@Test (priority=1)
	public void ExportContent_TC_DSMod_13_CopyFilesProjectPath() throws IOException { 
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_13_CopyFilesProjectPath");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_13): Verify the downloaded ESC Info csv.",ExtentColor.BLUE));
		
		File srcFile3 = new File("C:\\Users\\Sreedhar\\Downloads\\escinfo.csv");
		File destFile3 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv");
		FileUtils.copyFile(srcFile3, destFile3);
		Reporter.log("<font color='Lime'>File(escinfo.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
		logger.log(Status.PASS,MarkupHelper.createLabel("File(escinfo.csv) successfully copied to Downloads Project path folder.",ExtentColor.GREEN));

	}	

	@Test (priority=2)
	public void ExportContent_TC_DSMod_13_EmailableReport() throws FileNotFoundException, IOException {  
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_13_EmailableReport");
		
		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv.";
		BufferedReader reader = null;
		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(escinfo.csv) data added to emailable report with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("File(escinfo.csv) data added to emailable report.",ExtentColor.GREEN));

		for (String line = br.readLine(); 
				line != null; 
				line = br.readLine()) {
			Reporter.log(line);	
		}
		br.close();
	}

	@Test (priority=3)
	public void ExportContent_TC_DSMod_13_CompareData() throws FileNotFoundException, IOException {   

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_13_CompareData");
		
		String file1 = "C:\\Users\\Sreedhar\\Downloads\\escinfo.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\escinfo.csv";
		
		HashSet<String> f1 = new HashSet<String>(FileUtils.readLines(new File(file1)));
		HashSet<String> f2 = new HashSet<String>(FileUtils.readLines(new File(file2)));
		
		f1.removeAll(f2);
		System.out.println(f1.toString());
		String value = f1.toString();
		boolean result = f1.equals(f2);
		System.out.println(result);
		
		if(result==true) {
			Reporter.log("The data from the downloaded escinfo.csv file is same as API escinfo.csv file");
			logger.log(Status.PASS,MarkupHelper.createLabel("The data from the downloaded escinfo.csv file is same as API escinfo.csv file.",ExtentColor.GREEN));

		} else {
			Reporter.log("The data from the downloaded escinfo.csv file is not the same as API escinfo.csv file");
			logger.log(Status.FAIL,MarkupHelper.createLabel("The data from the downloaded escinfo.csv file is not the same as API escinfo.csv file.",ExtentColor.RED));
		}
		if(value!=null) {
			Reporter.log(value);
		}
	}
}




