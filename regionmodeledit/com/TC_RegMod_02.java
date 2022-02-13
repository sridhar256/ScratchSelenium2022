package kbh.regionmodeledit.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TC_RegMod_02 {
	
	WebDriver driver;
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsTest2.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest2.readDataFromTC("tc1");
   }

@Test 

	public void KBHomeLoginPage() throws InterruptedException, AWTException, FileNotFoundException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement username = driver.findElement(By.id("UserName"));
		sendkeys(driver, username, 10, tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");	
		
		WebElement password = driver.findElement(By.id("Password"));
		sendkeys(driver, password, 10, tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		
		WebElement login = driver.findElement(By.id("Submit"));
		clickOn(driver, login, 10);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		
		WebElement customApps = driver.findElement(By.xpath("//div[@class='mdc-tab-scroller__scroll-content']/a[1]"));
		clickOn(driver, customApps, 100);
		Reporter.log("User is able to click on 'Edit' tab with PASS Status");
		
		Thread.sleep(8000);
		WebElement createContent = driver.findElement(By.xpath("//span[@id='dijit_form_DropDownButton_8']"));
		createContent.sendKeys(Keys.ENTER);
		Reporter.log("User is able to click on 'Create Content' with PASS Status");
		
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(4000);
		WebElement regionPage = driver.findElement(By.xpath("//img[@alt='Region Page']"));
		clickOn(driver, regionPage, 100);
		Reporter.log("User is able to click on 'Region' page with PASS Status");
		
		tcData = CommonMethodsTest2.readDataFromTC("tc4");
		
		WebElement title = driver.findElement(By.xpath("//li[@id='uniqName_113_4']/label"));
		String titleText = title.getText();		
		if (title.getText().equals(tcData.get("Label1"))) {
			Reporter.log("<font color='Lime'>'Title' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Title' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement latitude = driver.findElement(By.xpath("//li[@id='uniqName_113_5']/label"));
		String latitudeText = latitude.getText();		
		if (latitude.getText().equals(tcData.get("Label2"))) {
			Reporter.log("<font color='Lime'>'Latitude' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Latitude' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement longitude = driver.findElement(By.xpath("//li[@id='uniqName_113_6']/label"));
		String longitudeText = longitude.getText();		
		if (longitude.getText().equals(tcData.get("Label3"))) {
			Reporter.log("<font color='Lime'>'Longitude' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Longitude' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement regionRadius = driver.findElement(By.xpath("//li[@id='uniqName_113_7']/label"));
		String regionRadiusText = regionRadius.getText();		
		if (regionRadius.getText().equals(tcData.get("Label4"))) {
			Reporter.log("<font color='Lime'>'Region Radius' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Region Radius' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement defaultMapZoom = driver.findElement(By.xpath("//li[@id='uniqName_113_8']/label"));
		String defaultMapZoomText = defaultMapZoom.getText();		
		if (defaultMapZoom.getText().equals(tcData.get("Label5"))) {
			Reporter.log("<font color='Lime'>'Default Map Zoom (Higher is Closer)' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Default Map Zoom (Higher is Closer)' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement filtersHeadline = driver.findElement(By.xpath("//li[@id='uniqName_113_9']/label"));
		String filtersHeadlineText = filtersHeadline.getText();		
		if (filtersHeadline.getText().equals(tcData.get("Label6"))) {
			Reporter.log("<font color='Lime'>'Filters Headline' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Filters Headline' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement contactPhone = driver.findElement(By.xpath("//li[@id='uniqName_113_13']/label"));
		String contactPhoneText = contactPhone.getText();		
		if (contactPhone.getText().equals(tcData.get("Label7"))) {
			Reporter.log("<font color='Lime'>'Contact Phone' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Contact Phone' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement divisionLeadID = driver.findElement(By.xpath("//li[@id='uniqName_113_11']/label"));
		String divisionLeadIDText = divisionLeadID.getText();		
		if (divisionLeadID.getText().equals(tcData.get("Label8"))) {
			Reporter.log("<font color='Lime'>'Division Lead ID' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Division Lead ID' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement spanishNHSFeed = driver.findElement(By.xpath("//label[@for='dijit_form_CheckBox_1']"));
		String spanishNHSFeedText = spanishNHSFeed.getText();		
		if (spanishNHSFeed.getText().equals(tcData.get("Label9"))) {
			Reporter.log("<font color='Lime'>'Spanish NHS Feed' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Spanish NHS Feed' text label does not exists in Region page with PASS status</font>");
		}
		
		WebElement regionID = driver.findElement(By.xpath("//label[@for='dijit_form_CheckBox_1']"));
		String regionIDText = regionID.getText();		
		if (regionID.getText().equals(tcData.get("Label10"))) {
			Reporter.log("<font color='Lime'>'Extra Field' text label exists in Region page with PASS status</font>");
		} else {
			Reporter.log("<font color='red'>'Extra Field' text label does not exists in Region page with PASS status</font>");
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
		// driver.quit();
	}
}

