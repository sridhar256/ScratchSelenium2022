package kbh.regionmodeledit.com;

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

public class ExportContent {
	
	WebDriver driver;
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsTest2.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest2.readDataFromTC("tc2");
   }

@Test 

	public void KBHomeLoginPage() throws InterruptedException {
		
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		Thread.sleep(4000);
		WebElement checkAll = driver.findElement(By.xpath("//button[@id='btnCheckAll']"));
		js.executeScript("arguments[0].scrollIntoView();", checkAll);
		js.executeScript("arguments[0].click()", checkAll);
		Reporter.log("User is able to click on 'Check All' button with PASS Status. "
				+ " All the communities are selected."
				+ "Hence Check All functionality is working fine. ");
		
		Thread.sleep(4000);
		WebElement unCheckAll = driver.findElement(By.xpath("//button[@id='btnUnCheckAll']"));
		js.executeScript("arguments[0].click()", unCheckAll);
		Reporter.log("User is able to click on 'UnCheck All' button with PASS Status. "
				+ " All the communities are unselected."
				+ "Hence UnCheck All functionality is working fine. ");
		
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


