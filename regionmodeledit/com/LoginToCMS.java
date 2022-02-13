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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToCMS {
	
	WebDriver driver;
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsTest2.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest2.readDataFromTC("tc1");
   }

@Test 
	public void KBHomeLoginPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement username = driver.findElement(By.id("UserName"));
		username.sendKeys(tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");
		Thread.sleep(3000);
			
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys(tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		Thread.sleep(2000);

		WebElement login = driver.findElement(By.id("Submit"));
		js.executeScript("arguments[0].click();", login);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		Thread.sleep(2000);

		WebElement qaDropdown = driver.findElement(By.xpath("//button[@title='qa']"));
		js.executeScript("arguments[0].click()", qaDropdown);
		Reporter.log("User is able to click on 'qaDropdown' with PASS Status");
		Thread.sleep(2000);
		
		WebElement logout = driver.findElement(By.xpath("//div[@id='epi-navigation-root']/div[2]/div/a[2]"));
		js.executeScript("arguments[0].click()", logout);
		Reporter.log("User is able to click on 'Log out' with PASS Status");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

