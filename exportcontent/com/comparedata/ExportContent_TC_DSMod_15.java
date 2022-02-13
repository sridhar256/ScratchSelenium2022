package kbh.exportcontent.com.comparedata;

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

public class ExportContent_TC_DSMod_15 {

	CommonMethodsExportContent cm = new CommonMethodsExportContent();
	HashMap<String, String> tcData;
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@Test (priority=1)
	public void ExportContent_TC_DSMod_15_CopyFilesProjectPath() throws IOException { 
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_15_CopyFilesProjectPath");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_15): Verify the downloaded Envision Links csv.",ExtentColor.BLUE));

		File srcFile2 = new File("C:\\Users\\Sreedhar\\Downloads\\envision.csv");
		File destFile2 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv");
		FileUtils.copyFile(srcFile2, destFile2);
		Reporter.log("<font color='Lime'>File(envision.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
		logger.log(Status.PASS,MarkupHelper.createLabel("File(envision.csv) successfully copied to Downloads Project path folder.",ExtentColor.GREEN));
	}

	@Test (priority=2)
	public void ExportContent_TC_DSMod_15_EmailableReport() throws FileNotFoundException, IOException {   

		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_15_EmailableReport");
		
		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\envision.csv.";
		BufferedReader reader = null;

		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(envision.csv) data added to emailable report with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("File(envision.csv) data added to emailable report.",ExtentColor.GREEN));

		for (String line = br.readLine(); 
				line != null; 
				line = br.readLine()) {
			Reporter.log(line);	
		}
		br.close();
	}


	@Test (priority=3)
	public void ExportContent_TC_DSMod_15_CompareData() throws FileNotFoundException, IOException {   

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_15_CompareData");
		
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
			Reporter.log("The data from the downloaded envision.csv file is same as API envision.csv file");
			logger.log(Status.PASS,MarkupHelper.createLabel("The data from the downloaded envision.csv file is same as API envision.csv file.",ExtentColor.GREEN));

		} else {
			Reporter.log("The data from the downloaded envision.csv file is not the same as API envision.csv file");
			logger.log(Status.FAIL,MarkupHelper.createLabel("The data from the downloaded envision.csv file is not the same as API envision.csv file.",ExtentColor.RED));
		}
		if(value!=null) {
			Reporter.log(value);
		}
	}
}




