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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import regression.com.ExtentReporManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportListener.ExtentReporterNGUpdated;

public class ExportContent_TC_DSMod_09 {

	WebDriver driver;
	CommonMethodsExportContent cm = new CommonMethodsExportContent();
	HashMap<String, String> tcData;
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;



	@Test (priority=1)
	public void ExportContent_TC_DSMod_09_CopyFilesProjectPath() throws IOException { 

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_09_CopyFilesProjectPath");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_11): Verify the downloaded flooe plan csv.",ExtentColor.BLUE));

		File srcFile1 = new File("C:\\Users\\Sreedhar\\Downloads\\floorplan.csv");
		File destFile1 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv");
		FileUtils.copyFile(srcFile1, destFile1);
		Reporter.log("<font color='Lime'>File(floorplan.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
		logger.log(Status.PASS,MarkupHelper.createLabel("File(floorplan.csv) successfully copied to Downloads Project path folder.",ExtentColor.GREEN));

	}

	@Test (priority=2)
	public void ExportContent_TC_DSMod_09_EmailableReport() throws FileNotFoundException, IOException {   

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_09_EmailableReport");

		String file = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv.";
		BufferedReader reader = null;
		InputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		Reporter.log("<font color='Lime'>File(floorplan.csv) data added to emailable report with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("File(floorplan.csv) data added to emailable report.",ExtentColor.GREEN));

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
	public void ExportContent_TC_DSMod_09_CompareData() throws FileNotFoundException, IOException {   

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_09_CompareData");

		String file1 = "C:\\Users\\Sreedhar\\Downloads\\floorplan.csv";
		String file2 = "C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv";

		HashSet<String> f1 = new HashSet<String>(FileUtils.readLines(new File(file1)));
		HashSet<String> f2 = new HashSet<String>(FileUtils.readLines(new File(file2)));

		f1.removeAll(f2);
		System.out.println(f1.toString());
		String value = f1.toString();
		boolean result = f1.equals(f2);
		System.out.println(result);

		if(result==true) {
			Reporter.log("The data from the downloaded floorplan.csv file is same as API floorplan.csv file");
			logger.log(Status.PASS,MarkupHelper.createLabel("The data from the downloaded floorplan.csv file is same as API floorplan.csv file.",ExtentColor.GREEN));

		} else {
			Reporter.log("The data from the downloaded floorplan.csv file is not the same as API floorplan.csv file");
			logger.log(Status.FAIL,MarkupHelper.createLabel("The data from the downloaded floorplan.csv file is not the same as API floorplan.csv file.",ExtentColor.RED));
		}
		if(value!=null) {
			Reporter.log(value);
		}
	}
}






