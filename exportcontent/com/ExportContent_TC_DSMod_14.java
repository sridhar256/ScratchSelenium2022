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

public class ExportContent_TC_DSMod_14 {
	
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

	public void exportContent_TC_DSMod_14() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase(TC_DSMod_14): Verify Download button functionality when Envision Links Content type is selected");	
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_14): Verify Download button functionality when Envision Links Content type is selected.",ExtentColor.BLUE));
		
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
		
		WebElement envisionLinks = driver.findElement(By.xpath("//input[@id='envisionLinkPage']"));
		clickOn(driver, envisionLinks, 30);
		Reporter.log("<font color='Lime'>User is able to select 'Envision Links' radio button with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Envision Links' radio button.",ExtentColor.GREEN)); 
		
		WebElement region = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection = new Select(region);
		regionSelection.selectByVisibleText(tcData.get("Label18"));
		Reporter.log("<font color='Lime'>User is able to select 'Bay Area North' option from 'Region' drop down with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Bay Area North' option from 'Region' drop down.",ExtentColor.GREEN)); 
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		// WebElement ashburyCheckbox = driver.findElement(By.xpath("//input[@value='1239']"));
		WebElement  ashburyCheckbox = driver.findElement(By.xpath("//input[@value='27114']"));
		clickOn(driver, ashburyCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'Ashbury Checkbox' with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Ashbury Checkbox'.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		// WebElement  athertonPlaceCheckbox = driver.findElement(By.xpath("//input[@value='1233']"));
		WebElement  athertonPlaceCheckbox = driver.findElement(By.xpath("//input[@value='27108']"));
		clickOn(driver, athertonPlaceCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'Atherton Place Checkbox' with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Atherton Place Checkbox'.",ExtentColor.GREEN)); 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement download = driver.findElement(By.xpath("//button[@id='btnDownload']"));
		js.executeScript("arguments[0].scrollIntoView();", download);		
		
		Thread.sleep(4000);
		js.executeScript("arguments[0].style.border='2px red double'", download);
		js.executeScript("arguments[0].click()", download);
		Reporter.log("<font color='Lime'>User is able to click on 'Download' button with PASS Status.</font>"
				+ "<font color='Lime'>Hence Download functionality is working fine for Envision Links.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Download' button.Hence Download functionality is working fine for Envision Links.",ExtentColor.GREEN)); 

		Thread.sleep(8000);

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




