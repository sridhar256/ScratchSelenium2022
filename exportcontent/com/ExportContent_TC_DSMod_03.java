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

public class ExportContent_TC_DSMod_03 {
	
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

	public void exportContent_TC_DSMod_03() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase (TC_DSMod_03): Verify content type selection");	
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase (TC_DSMod_03): Verify content type selection.",ExtentColor.BLUE)); 
		
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
		
		Thread.sleep(4000);
		WebElement floorPlan = driver.findElement(By.xpath("//input[@id='floorPlanPage'] [@type='radio']"));
		WebElement moveInReady = driver.findElement(By.xpath("//input[@id='moveInReadyPage'] [@type='radio']"));
		WebElement eSCInfo = driver.findElement(By.xpath("//input[@id='ESCInfoPage'] [@type='radio']"));
		WebElement envisionLinks = driver.findElement(By.xpath("//input[@id='envisionLinkPage'] [@type='radio']"));

		WebElement region = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection = new Select(region);
		regionSelection.selectByVisibleText(tcData.get("Label14"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px red double'", region);
		Reporter.log("<font color='Lime'>User is able to select 'Charlotte Area' option from 'Region' drop down with PASS Status</font>");		
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Charlotte Area' option from 'Region' drop down",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='2px red double'", floorPlan);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", floorPlan);
		
		if (floorPlan.isSelected() != false) {
			moveInReady.click();
			Reporter.log("<font color='Lime'>'Floor Plan' is a radio button field with default status as selected with PASS Status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Floor Plan' is a radio button field with default status as selected",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Floor Plan' is not a radio button field with default status as selected with FAIL Status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Floor Plan' is not a radio button field with default status as selected",ExtentColor.RED)); 
		}
		
		WebElement region1 = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection1 = new Select(region1);
		regionSelection1.selectByVisibleText(tcData.get("Label16"));
		Reporter.log("<font color='Lime'>User is able to select 'Bay Area North' option from 'Region' drop down with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Bay Area North' option from 'Region' drop down",ExtentColor.GREEN)); 
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].style.border='2px red double'", moveInReady);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", moveInReady);
		if (moveInReady.isSelected() != false) {
			eSCInfo.click();
			Reporter.log("<font color='Lime'>'Move In Ready' is a radio button field  with default status as unselected with  PASS Status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Move In Ready' is a radio button field with default status as selected",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Move In Ready' is not a radio button field with default status as selected with FAIL Status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Move In Ready' is not a radio button field with default status as selected",ExtentColor.RED)); 
		}
		
		WebElement region2 = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection2 = new Select(region2);
		regionSelection2.selectByVisibleText(tcData.get("Label17"));
		Reporter.log("<font color='Lime'>User is able to select 'Palm Coast Area' option from 'Region' drop down with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Palm Coast Area' option from 'Region' drop down",ExtentColor.GREEN)); 
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].style.border='2px red double'", eSCInfo);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", eSCInfo);
		if (eSCInfo.isSelected() != false) {
			envisionLinks.click();
			Reporter.log("<font color='Lime'>'ESC Info' is a radio button field with  with default status as unselected with  PASS Status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'ESC Info' is a radio button field with default status as selected",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'ESC Info' is not a radio button field with default status as selected with FAIL Status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'ESC Info' is not a radio button field with default status as selected",ExtentColor.RED)); 
		}
		
		WebElement region3 = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection3 = new Select(region3);
		regionSelection3.selectByVisibleText(tcData.get("Label18"));
		Reporter.log("<font color='Lime'>User is able to select 'Bay Area North' option from 'Region' drop down with PASS Status</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Bay Area North' option from 'Region' drop down",ExtentColor.GREEN)); 

		
		js.executeScript("arguments[0].style.border='2px red double'", envisionLinks);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", envisionLinks);
		if (envisionLinks.isSelected() != false) {
			floorPlan.click();
			Reporter.log("<font color='Lime'>'Envision Links' is a radio button field with  with default status as unselected with PASS Status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Envision Links' is a radio button field with default status as selected",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Envision Links' is not a radio button field with default status as selected with FAIL Status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Envision Links' is not a radio button field with default status as selected",ExtentColor.RED)); 
		}
		js.executeScript("arguments[0].style.border='0px red double'", region);
		
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




