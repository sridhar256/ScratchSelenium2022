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

	@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsExportContent.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsExportContent.readDataFromTC("tc1");
	}

	@Test (priority=1)

	public void exportContent_TC_DSMod_09() throws InterruptedException, FileNotFoundException, IOException {

		Reporter.log("TestCase(TC_DSMod_09): Verify the downloaded Floor Plan csv.");	
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_09): Verify the downloaded Floor Plan csv.",ExtentColor.BLUE));

		WebElement username = driver.findElement(By.id("UserName"));
		sendkeys(driver, username, 10, tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'qa' in email field",ExtentColor.GREEN)); 

		WebElement password = driver.findElement(By.id("Password"));
		sendkeys(driver, password, 10, tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Admin!23' in password field",ExtentColor.GREEN)); 

		WebElement login = driver.findElement(By.id("Submit"));
		clickOn(driver, login, 10);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Log in with Email' button",ExtentColor.GREEN)); 

		WebElement customApps = driver.findElement(By.xpath("//div[@class='mdc-tab-scroller__scroll-content']/a[3]"));
		clickOn(driver, customApps, 30);
		Reporter.log("User is able to click on 'Custom Apps' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Custom Apps' tab",ExtentColor.GREEN)); 

		Thread.sleep(4000);
		WebElement exportContent = driver.findElement(By.xpath("//a[contains(@href,'export')]"));
		clickOn(driver, exportContent, 30);
		Reporter.log("User is able to click on 'Export Content' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Export Content' tab",ExtentColor.GREEN)); 
	}

	public static void sendkeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);	
	}

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


	@Test (priority=2)
	public void ExportContent_TC_DSMod_09_CopyFilesProjectPath() throws IOException { 

		extent = ExtentReporManager.getReports();
		logger = extent.createTest("ExportContent_TC_DSMod_09_CopyFilesProjectPath");
		// logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_09): Verify the downloaded Floor Plan csv.",ExtentColor.BLUE));

		File srcFile1 = new File("C:\\Users\\Sreedhar\\Downloads\\floorplan.csv");
		File destFile1 = new File("C:\\Users\\Sreedhar\\workspace1\\Testing\\Downloads\\floorplan.csv");
		FileUtils.copyFile(srcFile1, destFile1);
		Reporter.log("<font color='Lime'>File(floorplan.csv) successfully copied to Downloads Project path folder with PASS Status.</font>");	
		logger.log(Status.PASS,MarkupHelper.createLabel("File(floorplan.csv) successfully copied to Downloads Project path folder.",ExtentColor.GREEN));

	}

	@Test (priority=3)
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

	@Test (priority=4)
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






