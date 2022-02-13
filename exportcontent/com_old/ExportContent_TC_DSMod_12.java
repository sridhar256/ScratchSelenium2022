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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExportContent_TC_DSMod_12 {
	
	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethods.readDataFromTC("tc1");
   }

@Test 

	public void exportContent_TC_DSMod_12() throws InterruptedException, FileNotFoundException, IOException {
	
		Reporter.log("TestCase(TC_DSMod_12): Verify Download button functionality when ESC Info Content type is selected");	
		
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
		
		WebElement eSCInfoSelection = driver.findElement(By.xpath("//input[@id='ESCInfoPage']"));
		clickOn(driver, eSCInfoSelection, 30);
		Reporter.log("<font color='Lime'>User is able to select 'ESC Info' radio button with PASS Status</font>");
				
		WebElement region = driver.findElement(By.xpath("//select[@id='regions']"));
		Select regionSelection = new Select(region);
		regionSelection.selectByVisibleText(tcData.get("Label17"));
		Reporter.log("<font color='Lime'>User is able to select 'Palm Coast Area' option from 'Region' drop down with PASS Status</font>");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement lasCasitasCheckbox = driver.findElement(By.xpath("//input[@value='828']"));
		clickOn(driver, lasCasitasCheckbox, 30);
		Reporter.log("<font color='Lime'>User is able to click on 'Las Casitas Checkbox' with PASS Status</font>");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement download = driver.findElement(By.xpath("//button[@id='btnDownload']"));
		js.executeScript("arguments[0].scrollIntoView();", download);		
		
		Thread.sleep(4000);
		js.executeScript("arguments[0].style.border='2px red double'", download);
		js.executeScript("arguments[0].click()", download);
		Reporter.log("<font color='Lime'>User is able to click on 'Download' button with PASS Status.</font> "
				+ "<font color='Lime'>Hence Download functionality is working fine for ESC Info.</font> ");
		
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




