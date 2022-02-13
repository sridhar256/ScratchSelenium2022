package kbh.exportcontent.com_old;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExportContent_TC_DSMod_02 {
	
	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethods.readDataFromTC("tc1");
   }

@Test 

	public void exportContent_TC_DSMod_02() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase (TC_DSMod_02): Verify Content types as radio buttons in the page");	
		
		WebElement username = driver.findElement(By.id("UserName"));
		sendkeys(driver, username, 10, tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");	
		
		WebElement password = driver.findElement(By.id("Password"));
		sendkeys(driver, password, 10, tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		
		WebElement login = driver.findElement(By.id("Submit"));
		clickOn(driver, login, 10);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		
		WebElement customApps = driver.findElement(By.xpath("//div[@class='mdc-tab-scroller__scroll-content']/a[3]"));
		clickOn(driver, customApps, 30);
		Reporter.log("User is able to click on 'Custom Apps' tab with PASS Status");
		
		Thread.sleep(4000);
		WebElement exportContent = driver.findElement(By.xpath("//a[contains(@href,'export')]"));
		clickOn(driver, exportContent, 30);
		Reporter.log("User is able to click on 'Export Content' tab with PASS Status");
				
		Thread.sleep(4000);
		WebElement floorPlan = driver.findElement(By.xpath("//input[@id='floorPlanPage'] [@type='radio']"));
		WebElement moveInReady = driver.findElement(By.xpath("//input[@id='moveInReadyPage'] [@type='radio']"));
		WebElement eSCInfo = driver.findElement(By.xpath("//input[@id='ESCInfoPage'] [@type='radio']"));
		WebElement envisionLinks = driver.findElement(By.xpath("//input[@id='envisionLinkPage'] [@type='radio']"));

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px red double'", floorPlan);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", floorPlan);
		if (floorPlan.isSelected() != false) {
			Reporter.log("<font color='Lime'>'Floor Plan' is a radio button field with default status as selected with PASS Status</font>");
		} else {
			Reporter.log("<font color='red'>'Floor Plan' is not a radio button field with default status as selected with FAIL Status</font>");
		}
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='2px red double'", moveInReady);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", moveInReady);
		if (moveInReady.isSelected() != true) {
			Reporter.log("<font color='Lime'>'Move In Ready' is a radio button field  with default status as unselected with  PASS Status</font>");
		} else {
			Reporter.log("<font color='red'>'Move In Ready' is not a radio button field with default status as selected with FAIL Status</font>");
		}
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='2px red double'", eSCInfo);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", eSCInfo);
		if (eSCInfo.isSelected() != true) {
			Reporter.log("<font color='Lime'>'ESC Info' is a radio button field with  with default status as unselected with  PASS Status</font>");
		} else {
			Reporter.log("<font color='red'>'ESC Info' is not a radio button field with default status as selected with FAIL Status</font>");
		}
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='2px red double'", envisionLinks);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='0px red double'", envisionLinks);
		if (envisionLinks.isSelected() != true) {
			Reporter.log("<font color='Lime'>'Envision Links' is a radio button field with  with default status as unselected with PASS Status</font>");
		}else {
			Reporter.log("<font color='red'>'Envision Links' is not a radio button field with default status as selected with FAIL Status</font>");
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




