package testing.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInMyKBNew {
	
	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethods.readDataFromTC("tc1");
	}

@Test 
	public void KBHomeLoginPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
        WebElement signin = driver.findElement(By.id("mykb"));
		js.executeScript("arguments[0].click()", signin);
		Reporter.log("User is able to click on 'SIGN IN' with PASS Status");
		Thread.sleep(2000);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstName.sendKeys(tcData.get("FirstName"));
		Reporter.log("User is able to input 'Sreedhar' in 'First Name' field with PASS Status");
		Thread.sleep(2000);
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastName.sendKeys(tcData.get("LastName"));
		Reporter.log("User is able to input 'Jasti' in 'Last Name' field with PASS Status");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(tcData.get("Email"));
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in 'Email' field with PASS Status");
		Thread.sleep(2000);
		
		WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='ConfirmEmail']"));
		confirmEmail.sendKeys(tcData.get("ConfirmEmail"));
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in 'Confirm Email' field with PASS Status");
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		WebElement password = driver.findElement(By.xpath("//input[@title='password']"));
		Thread.sleep(3000);
		act.sendKeys(password, tcData.get("Password")).build().perform();
		Reporter.log("User is able to input 'ejtrkppr' in password field with PASS Status");
		Thread.sleep(2000);
		
		if (driver.findElement(
				By.xpath("//input[@id='noti-02']")).isSelected() != true) {
				driver.findElement(By.xpath("//input[@id='noti-02']")).click();
				Reporter.log("User is able to select 'Terms and Conditions' checkbox field with PASS Status");
				Thread.sleep(2000);
		}		
		if (driver.findElement(
				By.xpath("//input[@id='EmailOptIN']")).isSelected() != false) {
				driver.findElement(By.xpath("//input[@id='EmailOptIN']")).click();
		}
		
		WebElement region = driver.findElement(By.xpath("//select[@id='RegionList']"));
		Select dropdownSelection = new Select(region);
		dropdownSelection.selectByVisibleText(tcData.get("SelectARegion"));
		Reporter.log("User is able to select 'Phoenix' option from 'Select a Region' drop down with PASS Status");
		Thread.sleep(2000);
		
		WebElement communityList = driver.findElement(By.xpath("//select[@id='CommunityList']"));
		Select dropdownSelection1 = new Select(communityList);
		dropdownSelection1.selectByVisibleText(tcData.get("SelectACommunity"));
		Reporter.log("User is able to select 'Marbella Park' option from 'Select a Community' drop down with PASS Status");
		Thread.sleep(2000);
		
		WebElement personalDescription = driver.findElement(By.xpath("//select[@id='RegistrationType']"));
		Select dropdownSelection2 = new Select(personalDescription);
		dropdownSelection2.selectByVisibleText(tcData.get("SelectOne"));
		Reporter.log("User is able to select 'I am looking for a new home' option from 'Select a Community' drop down with PASS Status");
		Thread.sleep(2000);
		
		WebElement createProfile = driver.findElement(By.xpath("//input[@id='RegSubmit']"));
		js.executeScript("arguments[0].click()", createProfile);
		Reporter.log("User is able to click on 'Create Profile' with PASS Status");
		Thread.sleep(2000);
					
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

