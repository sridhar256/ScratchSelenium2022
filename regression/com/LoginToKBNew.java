package regression.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.logging.*;

import extentReportListener.ExtentReporterNGUpdated;

public class LoginToKBNew {
	
	WebDriver driver;
	CommonMethodsTest cm = new CommonMethodsTest();
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	HashMap<String, String> tcData;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsTest.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest.readDataFromTC("tc1");
   }

@Test 
	public void KBHomeLoginPage() throws InterruptedException {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		extent = ExtentReporManager.getReports();
		logger = extent.createTest("KBHomeLoginPage");
		
        WebElement signin = driver.findElement(By.id("mykb"));
		js.executeScript("arguments[0].click()", signin);
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'SIGN IN' with PASS Status",ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

		Reporter.log("User is able to click on 'SIGN IN' with PASS Status");
		Thread.sleep(2000);
		
		WebElement haveAccount = driver.findElement(By.id("have-account"));
		js.executeScript("arguments[0].click()", haveAccount);
		Reporter.log("User is able to click on 'Already have an account' with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click on 'Already have an account",ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

		Thread.sleep(2000);
				
		WebElement email = driver.findElement(By.xpath("//form[@id='login-form']/div/p[2]/input"));
		email.sendKeys(tcData.get("Label1"));
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in email field with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'sreedhar@stellaragency.com' in email field with PASS Status",ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

		Thread.sleep(3000);
			
		Actions act = new Actions(driver);
		WebElement password = driver.findElement(By.xpath("//div[@id='login-dialog']/div[2]/form/div/p[4]/input"));
		Thread.sleep(3000);
		act.sendKeys(password, tcData.get("Label2")).build().perform();
		Reporter.log("User is able to input 'ejtrkppr' in password field with PASS Status");
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'ejtrkppr' in password field with PASS Status",ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

		Thread.sleep(2000);

		WebElement login = driver.findElement(By.xpath("//form[@id='login-form']/input"));
		js.executeScript("arguments[0].click();", login);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		logger.log(Status.FAIL,MarkupHelper.createLabel("User is able to click on 'Log in with Email with FAIL Status",ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath("//div[@id='container']/div/div/a"));
		js.executeScript("arguments[0].click()", logout);
		Reporter.log("User is able to click on 'Log out' with PASS Status");
		logger.log(Status.FAIL,MarkupHelper.createLabel("User is able to click on 'Log out' with PASS Status",ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

