package kbh.exportcontent.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import kbh.regionmodeledit.com.CommonMethodsTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

public class ExportContent_TC_DSMod_05 {
	
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

@Test 

	public void exportContent_TC_DSMod_05() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase(TC_DSMod_05): Verify list of communities");	
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_05): Verify list of communities.",ExtentColor.BLUE)); 
		
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
				
		WebElement region = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection = new Select(region);
		regionSelection.selectByVisibleText(tcData.get("Label14"));
		Reporter.log("User is able to select 'Charlotte Area' option from 'Region' drop down with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Charlotte Area' option from 'Region' drop down.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		
		tcData = CommonMethodsExportContent.readDataFromTC("tc1");
		Thread.sleep(4000);
		WebElement  bellaVista = driver.findElement(By.xpath("//ul[@id='communities']/li[1]"));
		String bellaVistaText = bellaVista.getText();
		if (bellaVista.getText().equals(tcData.get("Label50"))) {
			Reporter.log("<font color='Lime'>Bella Vista is a community for Charlotte Area region with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("Bella Vista is a community for Charlotte Area region.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>Bella Vista is not a community for Charlotte Area region with FAIL Status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("Bella Vista is not a community for Charlotte Area region.",ExtentColor.RED)); 
		}
		
		WebElement midlandCrossing = driver.findElement(By.xpath("//ul[@id='communities']/li[2]"));
		String midlandCrossingText = midlandCrossing.getText();	
		if (midlandCrossing.getText().equals(tcData.get("Label51"))) {
			Reporter.log("<font color='Lime'>Midland Crossing is a community for Charlotte Area region with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("Midland Crossing is a community for Charlotte Area region",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>Midland Crossing is not a community for Charlotte Area region with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("Midland Crossing is not a community for Charlotte Area region",ExtentColor.RED)); 
		}
		
		WebElement theHills = driver.findElement(By.xpath("//ul[@id='communities']/li[3]"));
		String theHillsText = theHills.getText();	
		if (theHills.getText().equals(tcData.get("Label52"))) {
			Reporter.log("<font color='Lime'>The Hills is a community for Charlotte Area region with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("The Hills is a community for Charlotte Area region.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>The Hills is not a community for Charlotte Area region with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("The Hills is not a community for Charlotte Area region.",ExtentColor.RED)); 
		}
		
		Thread.sleep(2000);
		WebElement bellaVistaCheckbox = driver.findElement(By.xpath("//ul[@id='communities']/li[1]/input"));
		clickOn(driver, bellaVistaCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'Bella Vista Checkbox' with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Bella Vista Checkbox'.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		WebElement midlandCrossingCheckbox = driver.findElement(By.xpath("//ul[@id='communities']/li[2]/input"));
		clickOn(driver, midlandCrossingCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'Midland Crossing Checkbox' with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Midland Crossing Checkbox'.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		WebElement theHillsCheckbox = driver.findElement(By.xpath("//ul[@id='communities']/li[3]/input"));
		clickOn(driver, theHillsCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'The Hills checkbox' with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'The Hills checkbox'.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
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
}




