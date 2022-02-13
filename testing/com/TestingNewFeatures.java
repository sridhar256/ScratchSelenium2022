package testing.com;

import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;


public class TestingNewFeatures {
	
WebDriver driver;		
	
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
	/*	
	@Test (priority = 1, groups = "PrivacyPolicyMainTestCase")
	public void privacyPolicy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		Reporter.log("User is able to click on privacyPolicy with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 2, groups = "linksValidation", dependsOnMethods = "privacyPolicy")
	public void link1WhatInformtion() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link1WhatInformtion = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[1]"));
		js.executeScript("arguments[0].click()", link1WhatInformtion);
		
		Reporter.log("User is able to click on 'What Information Does This Privacy Policy Cover?' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 3, groups = "linksValidation", dependsOnMethods = "privacyPolicy")
	public void link8SocialMediaPlugins() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link8SocialMediaPlugins = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[8]"));
		js.executeScript("arguments[0].click()", link8SocialMediaPlugins);
		
		Reporter.log("User is able to click on 'Social Media Plugins' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 4, groups = "linksValidation", dependsOnMethods = "privacyPolicy")
	public void link14DataRetention() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link14DataRetention = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[14]"));
		js.executeScript("arguments[0].click()", link14DataRetention);
		
		Reporter.log("User is able to click on 'Data Retention' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 5, groups = "linksValidation", dependsOnMethods = "privacyPolicy")
	public void link17PrivacyPolicy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link17PrivacyPolicy = driver.findElement(By.xpath("//main[@id='info']/div/span/p[3]/a"));
		js.executeScript("arguments[0].click()", link17PrivacyPolicy);
		
		Reporter.log("User is able to click on 'Privacy Policy' with PASS Status");
		Thread.sleep(2000);
	}

	@Test (priority = 6, groups = "linksValidation", dependsOnMethods = "privacyPolicy")
	public void link19ContentPosting() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link19ContentPosting = driver.findElement(By.xpath("//main[@id='info']/div/span/p[4]/a"));
		js.executeScript("arguments[0].click()", link19ContentPosting);
		
		Reporter.log("User is able to click on 'Content Posting and Community Guidelines' with PASS Status");
		Thread.sleep(2000);
	}
	
		@Test (invocationCount=10)
		public void invocationCount() throws InterruptedException {
			Reporter.log("User is able to click on 'Content Posting and Community Guidelines' with PASS Status");
			Thread.sleep(2000);
	}
		
		@Test (expectedExceptions=NumberFormatException.class)
		public void expectedExceptions() throws InterruptedException {
			Reporter.log("User is able to click on 'Content Posting and Community Guidelines' with PASS Status");
			Thread.sleep(2000);
	}
	*/	
		@Test
		public void validationTesting() throws InterruptedException {
			String title = driver.getTitle();
			// System.out.println(title);
			
			Assert.assertEquals(title, "New Home Builders In Your Area - KB Home", "Title is not matched");
			Reporter.log("Title is matched with PASS Status");
			Thread.sleep(2000);
	}
		
		@Test
		public void logoTesting() throws InterruptedException {
			
			WebElement kbhomeLogo = driver.findElement(By.xpath("//nav[@id='main-nav']/ul/li[1]/a/img"));
			
			 boolean kbhomeLogoTest = kbhomeLogo.isDisplayed();
			 Assert.assertTrue(kbhomeLogoTest);
			
			Reporter.log("Logo is displayed with PASS Status");
			Thread.sleep(2000);
	}
		
		@AfterMethod
		public void tearDown() {
			// driver.quit();
		}
	}


