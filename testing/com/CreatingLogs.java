package testing.com;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 









import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportListener.ExtentReporterNGUpdated;
 
public class CreatingLogs extends ExtentReporterNGUpdated
{
	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	HashMap<String, String> tcData;
	ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
     
    @BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethods.readDataFromTC("tc1");
   }
     
    @Test
    public void KBHomeLoginPage() throws InterruptedException
    {
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
		
        test = extent.createTest("logsGeneration");
        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
        test.log(Status.INFO, "I am in actual Test");
        test.log(Status.INFO, "We can write the actual test logic in this Test");
         
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
