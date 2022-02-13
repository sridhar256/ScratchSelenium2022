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

public class FeauturesSheet_TC_CommCustApp_01 {
	
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
	
		Reporter.log("TestCase(TC_CorpCustApp_01): Verify Feature Sheets Custom App.");	
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("FeauturesSheet_TC_CommCustApp_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(TC_CorpCustApp_01): Verify Feature Sheets Custom App.",ExtentColor.BLUE));
		
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

		
		WebElement categoryLabel = driver.findElement(By.xpath("//div[@id='corporateId']/div/div/div/div[1]/div[1]/h3"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px red double'", categoryLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", categoryLabel);

		String categoryLabelText = categoryLabel.getText();	
		if (categoryLabel.getText().equals(tcData.get("Label7"))) {
			Reporter.log("<font color='Lime'>'Category' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Category' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Category' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Category' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement corporateFeaturesLabel = driver.findElement(By.xpath("//div[@id='corporateId']/div/div/div/div[1]/div[2]/h3"));
		js.executeScript("arguments[0].style.border='2px red double'", corporateFeaturesLabel);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", corporateFeaturesLabel);

		String corporateFeaturesLabelText = corporateFeaturesLabel.getText();	
		if (corporateFeaturesLabel.getText().equals(tcData.get("Label8"))) {
			Reporter.log("<font color='Lime'>'Corporate Features' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Corporate Features' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Corporate Features' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Corporate Features' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement addNewCategoryButton = driver.findElement(By.xpath("//div[@id='corporateId']/div/div/div/div[3]/div[2]/button[1]"));
		js.executeScript("arguments[0].scrollIntoView();", addNewCategoryButton);
		js.executeScript("arguments[0].style.border='2px red double'", addNewCategoryButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", addNewCategoryButton);

		String addNewCategoryButtonText = addNewCategoryButton.getText();	
		if (addNewCategoryButton.getText().equals(tcData.get("Label9"))) {
			Reporter.log("<font color='Lime'>'Add New Category' button exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Add New Category' button exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Add New Category' button does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Add New Category' button does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement saveChangesButton = driver.findElement(By.xpath("//div[@id='corporateId']/div/div/div/div[3]/div[2]/button[2]"));
		js.executeScript("arguments[0].style.border='2px red double'", saveChangesButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", saveChangesButton);

		String saveChangesButtonText = saveChangesButton.getText();	
		if (saveChangesButton.getText().equals(tcData.get("Label10"))) {
			Reporter.log("<font color='Lime'>'Save Changes' button exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Save Changes' button exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Save Changes' button does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Save Changes' button does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}

		
		WebElement corporateFeatureSheet = driver.findElement(By.xpath("//a[@id='corporate-tab']"));
		js.executeScript("arguments[0].style.border='2px red double'", corporateFeatureSheet);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", corporateFeatureSheet);

		String corporateFeatureSheetText = corporateFeatureSheet.getText();	
		if (corporateFeatureSheet.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Corporate Feature Sheet' text label exists in Features Sheet/Corporate Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Corporate Feature Sheet' text label exists in Features Sheet/Corporate Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Corporate Feature Sheet' text label does not exist in Features Sheet/Corporate Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Corporate Feature Sheet' text label does not exist in Features Sheet/Corporate Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		js.executeScript("arguments[0].style.border='0px red double'", addNewCategoryButton);

		
		WebElement communityFeaturesSheet = driver.findElement(By.xpath("//a[@id='commuity-tab']"));
		clickOn(driver, communityFeaturesSheet, 30);
		Reporter.log("User is able to click on 'Community Features Sheet' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Community Features Sheet' tab",ExtentColor.GREEN));
		
		js.executeScript("arguments[0].style.border='2px red double'", communityFeaturesSheet);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", communityFeaturesSheet);

		String communityFeaturesSheetText = communityFeaturesSheet.getText();	
		if (communityFeaturesSheet.getText().equals(tcData.get("Label4"))) {
			Reporter.log("<font color='Lime'>'Community Features Sheet' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Community Features Sheet' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Community Features Sheet' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Community Features Sheet' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement modelFeatureSheets = driver.findElement(By.xpath("//a[@id='model-tab']"));
		clickOn(driver, modelFeatureSheets, 30);
		Reporter.log("User is able to click on 'Model Features Sheet' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Model Features Sheet' tab",ExtentColor.GREEN));
		
		js.executeScript("arguments[0].style.border='2px red double'", modelFeatureSheets);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", modelFeatureSheets);

		String modelFeatureSheetsText = modelFeatureSheets.getText();	
		if (modelFeatureSheets.getText().equals(tcData.get("Label5"))) {
			Reporter.log("<font color='Lime'>'Model Feature Sheets' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Model Feature Sheets' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Model Feature Sheets' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Model Feature Sheets' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
		}
		
		WebElement approveFeatureSheets = driver.findElement(By.xpath("//a[@id='featureApproval-tab']"));
		clickOn(driver, approveFeatureSheets, 30);
		Reporter.log("User is able to click on 'Approve Feature Sheets' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Approve Feature Sheets' tab",ExtentColor.GREEN));
		
		js.executeScript("arguments[0].style.border='2px red double'", approveFeatureSheets);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", approveFeatureSheets);

		String approveFeatureSheetsText = approveFeatureSheets.getText();	
		if (approveFeatureSheets.getText().equals(tcData.get("Label6"))) {
			Reporter.log("<font color='Lime'>'Approve Feature Sheets' text label exists in Features Sheet/Community Feature Sheet page with PASS status.</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Approve Feature Sheets' text label exists in Features Sheet/Community Feature Sheet page.",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Approve Feature Sheets' text label does not exist in Features Sheet/Community Feature Sheet page with FAIL status.</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Approve Feature Sheets' text label does not exist in Features Sheet/Community Feature Sheet Sheet page.",ExtentColor.RED)); 
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




