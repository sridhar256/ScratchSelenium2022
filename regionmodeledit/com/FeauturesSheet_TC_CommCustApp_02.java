package kbh.regionmodeledit.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import kbh.featuresheets.com.CommonMethodsFeatureSheets;
import kbh.regionmodeledit.com.CommonMethodsTest2;

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

public class FeauturesSheet_TC_CommCustApp_02 {
	
	WebDriver driver;
	CommonMethodsFeatureSheets cm = new CommonMethodsFeatureSheets();
	HashMap<String, String> tcData;
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsFeatureSheets.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsFeatureSheets.readDataFromTC("tc1");
   }

@Test 
	public void FeauturesSheet_TC_CommCustApp_02() throws InterruptedException, FileNotFoundException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Reporter.log("TestCase(TC_CommCustApp_02): Verify Community Features download section.");	
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_CommCustApp_02): Verify Community Features download section.",ExtentColor.BLUE));
		
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
		WebElement featureSheets = driver.findElement(By.xpath("//a[contains(@href,'feature')]"));
		clickOn(driver, featureSheets, 30);
		Reporter.log("User is able to click on 'Feature Sheets' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Feature Sheets' tab",ExtentColor.GREEN)); 

		
		Thread.sleep(4000);
		WebElement community = driver.findElement(By.xpath("//a[@onclick='community()']"));
		clickOn(driver, community, 30);
		Reporter.log("User is able to click on 'Community' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Community' tab.",ExtentColor.GREEN)); 

		
		Thread.sleep(4000);
		WebElement regionLabel = driver.findElement(By.xpath("//div[@id='communityId']/div/div[1]/div[1]/div/label"));
		js.executeScript("arguments[0].style.border='2px red double'", regionLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", regionLabel);

		String regionLabelText = regionLabel.getText();	
		if (regionLabel.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Region' text label exists in Community/Features Sheet page with PASS status.</font>");
		} else {
			Reporter.log("<font color='red'>'Region' text label does not exist in Community/Features Sheet page with FAIL status.</font>");
		}
		
		Thread.sleep(4000);
		WebElement communityLabel = driver.findElement(By.xpath("//div[@id='communityId']/div/div[1]/div[2]/div/label"));
		js.executeScript("arguments[0].style.border='2px red double'", communityLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", communityLabel);

		String communityLabelText = communityLabel.getText();	
		if (communityLabel.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Community' text label exists in Community/Features Sheet page with PASS status.</font>");
		} else {
			Reporter.log("<font color='red'>'Community' text label does not exist in Community/Features Sheet page with FAIL status.</font>");
		}
		
		Thread.sleep(4000);
		WebElement downloadCommunityFeaturesButton = driver.findElement(By.xpath("//button[text()='Download Community Features']"));
		js.executeScript("arguments[0].style.border='2px red double'", downloadCommunityFeaturesButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", downloadCommunityFeaturesButton);

		String downloadCommunityFeaturesButtonText = downloadCommunityFeaturesButton.getText();	
		if (downloadCommunityFeaturesButton.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Download Community Features' button exists in Community/Features Sheet page with PASS status.</font>");
		} else {
			Reporter.log("<font color='red'>'Download Community Features' button does not exist in Community/Features Sheet page with FAIL status.</font>");
		}
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




