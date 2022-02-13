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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportListener.ExtentReporterNGUpdated;

public class LoginToKBNew extends ExtentReporterNGUpdated {

	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	HashMap<String, String> tcData;
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

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

		WebElement haveAccount = driver.findElement(By.id("have-account"));
		js.executeScript("arguments[0].click()", haveAccount);
		Reporter.log("User is able to click on 'Already have an account' with PASS Status");

		logger = extent.createTest("KBHomeLoginPage");
		logger.createNode("User is able to click on 'SIGN IN' with PASS Status");
		logger.info("User is able to click on 'SIGN IN' with PASS Status");
		logger.pass("details");

		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//form[@id='login-form']/div/p[2]/input"));
		email.sendKeys(tcData.get("Username"));
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in email field with PASS Status");
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		WebElement password = driver.findElement(By.xpath("//div[@id='login-dialog']/div[2]/form/div/p[4]/input"));
		Thread.sleep(3000);
		act.sendKeys(password, tcData.get("Password")).build().perform();
		Reporter.log("User is able to input 'ejtrkppr' in password field with PASS Status");
		Thread.sleep(2000);

		WebElement login = driver.findElement(By.xpath("//form[@id='login-form']/input"));
		js.executeScript("arguments[0].click();", login);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath("//div[@id='container']/div/div/a"));
		js.executeScript("arguments[0].click()", logout);
		Reporter.log("User is able to click on 'Log out' with PASS Status");
		Thread.sleep(2000);

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

