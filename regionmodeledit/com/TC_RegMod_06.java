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

public class TC_RegMod_06 {
	
	WebDriver driver;
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethodsTest2.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest2.readDataFromTC("tc2");
   }

@Test 

	public void KBHomeLoginPage() throws InterruptedException, FileNotFoundException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement username = driver.findElement(By.id("UserName"));
		sendkeys(driver, username, 10, tcData.get("Label1"));
		Reporter.log("User is able to input 'qa' in email field with PASS Status");	
		
		WebElement password = driver.findElement(By.id("Password"));
		sendkeys(driver, password, 10, tcData.get("Label2"));
		Reporter.log("User is able to input 'Admin!23' in password field with PASS Status");
		
		WebElement login = driver.findElement(By.id("Submit"));
		clickOn(driver, login, 10);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		
		WebElement customApps = driver.findElement(By.xpath("//div[@class='mdc-tab-scroller__scroll-content']/a[1]"));
		clickOn(driver, customApps, 60);
		Reporter.log("User is able to click on 'Edit' tab with PASS Status");
		
		Thread.sleep(8000);
		WebElement toolNavigationPane = driver.findElement(By.id("uniqName_51_70"));
		// clickOn(driver, toolNavigationPane, 60);
		js.executeScript("arguments[0].click()", toolNavigationPane);
		Reporter.log("User is able to click on 'Tool Navigation Pane' with PASS Status");
		
		Thread.sleep(4000);
		WebElement plusLocations = driver.findElement(By.xpath("//div[@id='uniqName_4_20']/div/span/span[1]"));
		js.executeScript("arguments[0].click()", plusLocations);
		Reporter.log("User is able to click on 'Plus icon beside Locations' with PASS Status");
		
		Thread.sleep(4000);
		WebElement plusArizona = driver.findElement(By.xpath("//div[@id='uniqName_4_27']/div/span/span[1]"));
		js.executeScript("arguments[0].click()", plusArizona);
		Reporter.log("User is able to click on 'Plus icon beside Arizona' with PASS Status");
		
		Thread.sleep(4000);
		WebElement plusRegions = driver.findElement(By.xpath("//div[@id='uniqName_4_45']/div/span/span[1]"));
		js.executeScript("arguments[0].click()", plusRegions);
		Reporter.log("User is able to click on 'Plus icon beside Regions' with PASS Status");
		
		WebElement phoenixClick = driver.findElement(By.xpath("//div[@id='uniqName_4_46']/div[1]"));
		Actions act = new Actions(driver);
		act.clickAndHold(phoenixClick).click().build().perform();
		Reporter.log("User is able to click on 'Phoenix' with PASS Status");
		
		WebElement allProperties = driver.findElement(By.xpath("//span[@id='dijit_form_Button_10']"));
		js.executeScript("arguments[0].click()", allProperties);
		Reporter.log("User is able to click on 'All Properties' icon with PASS Status");
		
		WebElement phoenixUI = driver.findElement(By.xpath("//span[@id='dijit_form_DropDownButton_21']"));
		// js.executeScript("arguments[0].click()", phoenixUI);
		act.clickAndHold(phoenixUI).click().build().perform();
		Reporter.log("User is able to click on 'All Properties' icon with PASS Status");
		
		tcData = CommonMethodsTest2.readDataFromTC("tc5");
		
		WebElement content = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_102']"));
		String contentText = content.getText();		
		if (content.getText().equals(tcData.get("Label1"))) {
			Reporter.log("FieldLabel1Pass");
		} else {
			Reporter.log("FieldLabel1Fail");
		}
		
		WebElement additionalCommunities = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_104']"));
		String additionalCommunitiesText = additionalCommunities.getText();		
		if (additionalCommunities.getText().equals(tcData.get("Label2"))) {
			Reporter.log("FieldLabel2Pass");
		} else {
			Reporter.log("FieldLabel2Fail");
		}
		
		WebElement regionContact = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_105']"));
		String regionContactText = regionContact.getText();		
		if (regionContact.getText().equals(tcData.get("Label3"))) {
			Reporter.log("FieldLabel3Pass");
		} else {
			Reporter.log("FieldLabel3Fail");
		}
		
		WebElement images = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_108']"));
		String imagesText = images.getText();		
		if (images.getText().equals(tcData.get("Label4"))) {
			Reporter.log("FieldLabel4Pass");
		} else {
			Reporter.log("FieldLabel4Fail");
		}
		
		WebElement homeFindingSpecialist = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_109']"));
		String homeFindingSpecialistText = homeFindingSpecialist.getText();		
		if (homeFindingSpecialist.getText().equals(tcData.get("Label5"))) {
			Reporter.log("FieldLabel5Pass");
		} else {
			Reporter.log("FieldLabel5Fail");
		}
		
		WebElement onlineDesignStudioCommunityLandingPage = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_110']"));
		String onlineDesignStudioCommunityLandingPageText = onlineDesignStudioCommunityLandingPage.getText();		
		if (onlineDesignStudioCommunityLandingPage.getText().equals(tcData.get("Label6"))) {
			Reporter.log("FieldLabel6Pass");
		} else {
			Reporter.log("FieldLabel6Fail");
		}
		
		WebElement seoGroup = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_113']"));
		String seoGroupText = seoGroup.getText();
		if (seoGroup.getText().equals(tcData.get("Label7"))) {
			Reporter.log("FieldLabel7Pass");
		} else {
			Reporter.log("FieldLabel7Fail");
		}
		
		Thread.sleep(5000);
		WebElement triangleIcon = driver.findElement(By.xpath("//div[@id='uniqName_46_6_tablist_rightBtn']/img"));
		js.executeScript("arguments[0].click()", triangleIcon);
		Reporter.log("User is able to click on 'Log in with Email' with PASS Status");
		
		WebElement homeownerDocuments = driver.findElement(By.xpath("//span[@id='uniqName_46_6_tablist_dijit__TemplatedMixin_115']"));
		String homeownerDocumentsText = homeownerDocuments.getText();		
		if (homeownerDocuments.getText().equals(tcData.get("Label8"))) {
			Reporter.log("FieldLabel8Pass");
		} else {
			Reporter.log("FieldLabel8Fail");
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



