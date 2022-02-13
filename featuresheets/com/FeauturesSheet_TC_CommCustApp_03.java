package kbh.featuresheets.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import kbh.exportcontent.com.CommonMethodsExportContent;
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

public class FeauturesSheet_TC_CommCustApp_03 {
	
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
	public void FeauturesSheet_TC_CommCustApp_01() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase(TC_CorpCustApp_03): Verify Community Features download section.");	
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("FeauturesSheet_TC_CommCustApp_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_CorpCustApp_03): Verify Community Features download section.",ExtentColor.BLUE));
		
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

		WebElement communityFeaturesSheet = driver.findElement(By.xpath("//a[@id='commuity-tab']"));
		clickOn(driver, communityFeaturesSheet, 30);
		Reporter.log("User is able to click on 'Community Features Sheet' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Community Features Sheet' tab",ExtentColor.GREEN));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px red double'", communityFeaturesSheet);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", communityFeaturesSheet);

	
		
		WebElement regionLabel = driver.findElement(By.xpath("//div[@id='communityId']/div/div/div[1]/div/div[1]/div/label"));
		js.executeScript("arguments[0].style.border='2px red double'", regionLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", regionLabel);

		String regionLabelText = regionLabel.getText();	
		System.out.println(regionLabelText);
		System.out.println(tcData.get("Label11"));
		
		if (regionLabel.getText().equals(tcData.get("Label11"))) {
			Reporter.log("<font color='Lime'>'Region' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Region' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Region' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Region' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement communityLabel = driver.findElement(By.xpath("//div[@id='communityId']/div/div/div[1]/div/div[2]/div/label"));
		js.executeScript("arguments[0].style.border='2px red double'", communityLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", communityLabel);

		String communityLabelText = communityLabel.getText();	
		if (communityLabel.getText().equals(tcData.get("Label12"))) {
			Reporter.log("<font color='Lime'>'Community' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Community' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Community' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Community' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement downloadLabel = driver.findElement(By.xpath("//button[@id='btnDownloadLiveFeaturesExcel_Community']"));
		js.executeScript("arguments[0].style.border='2px red double'", downloadLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", downloadLabel);

		String downloadLabelText = downloadLabel.getText();	
		if (downloadLabel.getText().equals(tcData.get("Label13"))) {
			Reporter.log("<font color='Lime'>'Download' button exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Download' button exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Download' button does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Download' button does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
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




