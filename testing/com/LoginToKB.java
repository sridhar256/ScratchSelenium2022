package testing.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportListener.ExtentReporterNGUpdated;

public class LoginToKB {

	WebDriver driver;
	ExtentReporterNGUpdated er = new ExtentReporterNGUpdated();
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.kbhome.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//form[@id='login-form']/div/p[2]/input"));
		js.executeScript("arguments[0].value = 'sreedhar@stellaragency.com';", email);
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in email field with PASS Status");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//form[@id='login-form']/div/p[4]/input"));
		js.executeScript("arguments[0].value = 'ejtrkppr';", password);
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

		//ExtentTest logger=extent.createTest("LoginTest");

		// log method will add logs in report and provide the log steps which will come in report
		//logger.log(Status.INFO, "Login to amazon");


		// Flush method will write the test in report- This is mandatory step  
	//	extent.flush();

		// You can call createTest method multiple times depends on your requirement
		// In our case we are calling twice which will add 2 testcases in our report
		//ExtentTest logger2=extent.createTest("Logoff Test");
		//logger.log(Status.INFO, "Logout to amazon");

		
		// This will add another test in report
		extent.flush();



	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
