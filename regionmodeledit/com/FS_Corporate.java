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

public class FS_Corporate {
	
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
		
		WebElement featureSheets = driver.findElement(By.xpath("//a[contains(@href,'feature')]"));
		clickOn(driver, featureSheets, 30);
		Reporter.log("User is able to click on 'Feature Sheets' tab with PASS Status");
		
		WebElement addNewCategory = driver.findElement(By.id("Add New Category"));
		clickOn(driver, addNewCategory, 30);
		Reporter.log("User is able to click on 'Add New Category' tab with PASS Status");
		
		Actions act = new Actions(driver);
		WebElement category1 = driver.findElement(By.id("CatInp0"));
		act.sendKeys(category1, tcData.get("Label3")).build().perform();
		Reporter.log("User is able to input 'Distinctive Exterior Details' in category field with PASS Status");
		
		WebElement plusIcon = driver.findElement(By.id("anchor0"));
		clickOn(driver, plusIcon, 30);
		Reporter.log("User is able to click on 'Plus icon' tab with PASS Status");
		
		WebElement corporateFeatures = driver.findElement(By.id("ulist0inp0"));
		act.sendKeys(corporateFeatures, tcData.get("Label4")).build().perform();
		Reporter.log("User is able to input 'Concrete roof tiles' in category features field with PASS Status");
		
		WebElement saveCategory = driver.findElement(By.id("Save Category"));
		clickOn(driver, saveCategory, 30);
		Reporter.log("User is able to click on 'Save Category' icon with PASS Status");
		
		WebElement exportContent = driver.findElement(By.xpath("//a[contains(@href,'export')]"));
		clickOn(driver, exportContent, 30);
		Reporter.log("User is able to click on 'Export Content' tab with PASS Status");
		
		WebElement featureSheets1 = driver.findElement(By.xpath("//a[contains(@href,'feature')]"));
		clickOn(driver, featureSheets1, 30);
		Reporter.log("User is able to click on 'Feature Sheets' tab with PASS Status");
		
		WebElement deleteIcon = driver.findElement(By.id("anchorDel0"));
		clickOn(driver, deleteIcon, 30);
		Reporter.log("User is able to click on 'Plus icon' tab with PASS Status");
		
		WebElement saveCategory1 = driver.findElement(By.id("Save Category"));
		clickOn(driver, saveCategory1, 30);
		Reporter.log("User is able to click on 'Save Category' icon with PASS Status");
		
		WebElement exportContent1 = driver.findElement(By.xpath("//a[contains(@href,'export')]"));
		clickOn(driver, exportContent1, 30);
		Reporter.log("User is able to click on 'Export Content' tab with PASS Status");
		
		WebElement featureSheets2 = driver.findElement(By.xpath("//a[contains(@href,'feature')]"));
		clickOn(driver, featureSheets2, 30);
		Reporter.log("User is able to click on 'Feature Sheets' tab with PASS Status");
		
		if (driver.findElement(By.id("CatInp0")).isDisplayed() == true){
			Reporter.log("Deletion of category Test Case is FAIL");
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
		// driver.quit();
	}
}

/*Observations
1. Corporate Tab: Delete of Category fields doesn't work when it has 1 category field.
2. Corporate Tab: Please change the button name from 'Add New category' to 'Add New Category'.
3. Community tab: Typo error for 'Documnet' ==> 'Document'
4. Feature Approval Tab: Please change the button name from 'View live PDF' to 'View Live PDF'.
*/

