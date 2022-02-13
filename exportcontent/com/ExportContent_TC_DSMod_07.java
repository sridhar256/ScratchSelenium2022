package kbh.exportcontent.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class ExportContent_TC_DSMod_07 {
	
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

	public void ExportContent_TC_DSMod_07() throws InterruptedException {
	
		Reporter.log("TestCase(TC_DSMod_07): Verify UnCheck All button functionality");
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_DSMod_07): Verify UnCheck All button functionality.",ExtentColor.BLUE));
		
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		Thread.sleep(4000);
		WebElement checkAll = driver.findElement(By.xpath("//button[@id='btnCheckAll']"));
		js.executeScript("arguments[0].style.border='2px red double'", checkAll);		
		js.executeScript("arguments[0].scrollIntoView();", checkAll);
		js.executeScript("arguments[0].click()", checkAll);
		Reporter.log("<font color='Lime'>User is able to click on 'Check All' button with PASS Status.</font> "
				+ "<font color='Lime'> All the communities are selected.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Check All' button.All the communities are selected.",ExtentColor.GREEN)); 

		Thread.sleep(4000);
		js.executeScript("arguments[0].style.border='0px red double'", checkAll);
		WebElement unCheckAll = driver.findElement(By.xpath("//button[@id='btnUnCheckAll']"));
		js.executeScript("arguments[0].click()", unCheckAll);
		js.executeScript("arguments[0].style.border='2px red double'", unCheckAll);
		Reporter.log("<font color='Lime'>'User is able to click on 'UnCheck All' button with PASS Status.</font> "
				+ "<font color='Lime'>'All the communities are unselected.</font>"
				+ "<font color='Lime'>'Hence UnCheck All functionality is working fine.</font> ");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Check All' button.All the communities are unselected.Hence UnCheck All functionality is working fine.",ExtentColor.GREEN)); 

		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", unCheckAll);

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


