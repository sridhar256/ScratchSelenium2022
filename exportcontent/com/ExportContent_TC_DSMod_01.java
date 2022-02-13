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

public class ExportContent_TC_DSMod_01 {
	
	WebDriver driver;
	CommonMethodsExportContent cm = new CommonMethodsExportContent();
	HashMap<String, String> tcData;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsExportContent.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsExportContent.readDataFromTC("tc1");
   }

@Test 
	public void exportContent_TC_DSMod_01() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase (TC_DSMod_01): Verify Export Content IDs page.");	
		
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("exportContent_TC_DSMod_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase (TC_DSMod_01): Verify Export Content IDs page.",ExtentColor.BLUE)); 

		
		WebElement username = driver.findElement(By.id("UserName"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px red double'", username);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", username);
		sendkeys(driver, username, 10, tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'qa' in email field",ExtentColor.GREEN)); 

		
		WebElement password = driver.findElement(By.id("Password"));
		js.executeScript("arguments[0].style.border='2px red double'", password);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", password);
		sendkeys(driver, password, 10, tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Admin!23' in password field",ExtentColor.GREEN)); 

		
		WebElement login = driver.findElement(By.id("Submit"));
		js.executeScript("arguments[0].style.border='2px red double'", login);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", login);
		clickOn(driver, login, 10);
		Reporter.log("User is able to click on 'Log in with Email' button with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Log in with Email' button",ExtentColor.GREEN)); 

		
		WebElement customApps = driver.findElement(By.xpath("//div[@class='mdc-tab-scroller__scroll-content']/a[3]"));
		js.executeScript("arguments[0].style.border='2px red double'", customApps);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", customApps);
		clickOn(driver, customApps, 30);
		Reporter.log("User is able to click on 'Custom Apps' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Custom Apps' tab",ExtentColor.GREEN)); 

		
		Thread.sleep(4000);
		WebElement exportContent = driver.findElement(By.xpath("//a[contains(@href,'export')]"));
		js.executeScript("arguments[0].style.border='2px red double'", exportContent);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", exportContent);
		clickOn(driver, exportContent, 30);
		Reporter.log("User is able to click on 'Export Content' tab with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Export Content' tab",ExtentColor.GREEN)); 

		WebElement region = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection = new Select(region);
		regionSelection.selectByVisibleText(tcData.get("Label14"));
		Reporter.log("<font color='Lime'>User is able to select 'Bay Area North' option from 'Region' drop down with PASS Status.</font>");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Bay Area North' option from 'Region' drop down",ExtentColor.GREEN)); 

		Thread.sleep(2000);
				
		tcData = CommonMethodsExportContent.readDataFromTC("tc1");
		Thread.sleep(4000);
		WebElement exportContentIDs = driver.findElement(By.xpath("//h5[@class='card-title']"));
		js.executeScript("arguments[0].style.border='2px red double'", exportContentIDs);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", exportContentIDs);

		String exportContentIDsText = exportContentIDs.getText();
		if (exportContentIDs.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Export Content IDs' text label exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Export Content IDs' text label exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'Export Content IDs' text label does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Export Content IDs' text label does not exist exists in Export Content page",ExtentColor.RED)); 

		}
		
		Thread.sleep(4000);
		WebElement usethisapptohelpexportcontentIDs = driver.findElement(By.xpath("//h6[@class='card-subtitle mb-2 text-muted']"));
		
		js.executeScript("arguments[0].style.border='2px red double'", usethisapptohelpexportcontentIDs);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", usethisapptohelpexportcontentIDs);		
		
		String usethisapptohelpexportcontentIDsText = usethisapptohelpexportcontentIDs.getText();	
		if (usethisapptohelpexportcontentIDs.getText().equals(tcData.get("Label4"))) {
			Reporter.log("<font color='Lime'>'Use this app to help export content IDs' text label exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Use this app to help export content IDs' text label exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'Use this app to help export content IDs' text label does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Use this app to help export content IDs' text label does not exist in Export Content page",ExtentColor.RED)); 

		}
		
		WebElement floorPlan = driver.findElement(By.xpath("//label[@for='floorPlanPage']"));
		js.executeScript("arguments[0].style.border='2px red double'", floorPlan);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", floorPlan);
		
		String floorPlanText = floorPlan.getText();		
		if (floorPlan.getText().equals(tcData.get("Label5"))) {
			Reporter.log("<font color='Lime'>'Floor Plan' radio button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Floor Plan' radio button exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'Floor Plan' radio button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Floor Plan' radio button does not exist in Export Content page",ExtentColor.RED)); 

		}
		
		WebElement moveInReady = driver.findElement(By.xpath("//label[@for='moveInReadyPage']"));
		js.executeScript("arguments[0].style.border='2px red double'", moveInReady);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", moveInReady);
		
		String moveInReadyText = moveInReady.getText();		
		if (moveInReady.getText().equals(tcData.get("Label6"))) {
			Reporter.log("<font color='Lime'>'Move In Ready' radio button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Move In Ready' radio button exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'Move In Ready' radio button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Move In Ready' radio button does not exist in Export Content page",ExtentColor.RED)); 

		}
		
		WebElement eSCInfo = driver.findElement(By.xpath("//label[@for='ESCInfoPage']"));
		String eSCInfoText = eSCInfo.getText();	
		js.executeScript("arguments[0].style.border='2px red double'", eSCInfo);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", eSCInfo);
		
		if (eSCInfo.getText().equals(tcData.get("Label7"))) {
			Reporter.log("<font color='Lime'>'ESC Info' radio button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'ESC Info' radio button exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'ESC Info' radio button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'ESC Info' radio button does not exist exists in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement envisionLinks = driver.findElement(By.xpath("//label[@for='envisionLinkPage']"));
		String envisionLinksText = envisionLinks.getText();	
		
		js.executeScript("arguments[0].style.border='2px red double'", envisionLinks);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", envisionLinks);
		
		if (envisionLinks.getText().equals(tcData.get("Label8"))) {
			Reporter.log("<font color='Lime'>'Envision Links' radio button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Envision Links' radio button exists in Export Content page",ExtentColor.GREEN)); 

		} else {
			Reporter.log("<font color='red'>'Envision Links' radio button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Envision Links' radio button does not exist in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement region1  = driver.findElement(By.xpath("//label[@for='regions']"));
		String region1Text = region1.getText();
		
		js.executeScript("arguments[0].style.border='2px red double'", region1);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", region1);
		
		if (region1.getText().equals(tcData.get("Label9"))) {
			Reporter.log("<font color='Lime'>'Region' dropdown field exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel(">'Region' dropdown field exists in Export Content page",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Region' dropdown field does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Region' dropdown field does not exist in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement communities  = driver.findElement(By.xpath("//h4[@class='mb-3']"));
		String communitiesText = communities.getText();		
		
		js.executeScript("arguments[0].style.border='2px red double'", communities);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", communities);
		
		if (communities.getText().equals(tcData.get("Label10"))) {
			Reporter.log("<font color='Lime'>'Communities' field label exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Communities' field label exists in Export Content page",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Communities' field label does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Communities' field label does not exist in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement checkAll = driver.findElement(By.xpath("//button[@id='btnCheckAll']"));
		js.executeScript("arguments[0].scrollIntoView();", checkAll);
		Thread.sleep(4000);
		
		js.executeScript("arguments[0].style.border='2px red double'", checkAll);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", checkAll);
		
		String checkAllText = checkAll.getText();		
		if (checkAll.getText().equals(tcData.get("Label11"))) {
			Reporter.log("<font color='Lime'>'Check All' button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Check All' button exists in Export Content page",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Check All' button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Check All' button does not exist in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement unCheckAll = driver.findElement(By.xpath("//button[@id='btnUnCheckAll']"));
		String unCheckAllText = unCheckAll.getText();	
		
		js.executeScript("arguments[0].style.border='2px red double'", unCheckAll);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", unCheckAll);
		
		if (unCheckAll.getText().equals(tcData.get("Label12"))) {
			Reporter.log("<font color='Lime'>'UnCheck All' button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel(">'UnCheck All' button exists in Export Content page",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'UnCheck All' button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'UnCheck All' button does not exist in Export Content page",ExtentColor.RED)); 
		}
		
		WebElement download = driver.findElement(By.xpath("//button[@id='btnDownload']"));
		String downloadText = download.getText();	
		
		js.executeScript("arguments[0].style.border='2px red double'", download);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", download);
		
		if (download.getText().equals(tcData.get("Label13"))) {
			Reporter.log("<font color='Lime'>'Download' button exists in Export Content page with PASS status</font>");
			logger.log(Status.PASS,MarkupHelper.createLabel("'Download' button exists in Export Content page",ExtentColor.GREEN)); 
		} else {
			Reporter.log("<font color='red'>'Download' button does not exist in Export Content page with FAIL status</font>");
			logger.log(Status.FAIL,MarkupHelper.createLabel("'Download' button does not exist in Export Content page",ExtentColor.RED)); 
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




