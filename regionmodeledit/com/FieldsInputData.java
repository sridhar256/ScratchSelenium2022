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

public class FieldsInputData {
	
	WebDriver driver;
	CommonMethodsTest2 cm = new CommonMethodsTest2();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		// driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethodsTest2.readDataFromTC("tc1");
   }

@Test 
	public void KBHomeLoginPage() throws InterruptedException, FileNotFoundException, IOException {
	
	tcData = CommonMethodsTest2.readDataFromTC("tc1");

		System.out.println(tcData.get("Label1"));
		System.out.println(tcData.get("Label2"));
		System.out.println(tcData.get("Label3"));
		System.out.println(tcData.get("Label4"));
		System.out.println(tcData.get("Label5"));
		System.out.println(tcData.get("Label6"));
		System.out.println(tcData.get("Label7"));
		System.out.println(tcData.get("Label8"));
		System.out.println(tcData.get("Label9"));
		System.out.println(tcData.get("Label10"));
		System.out.println();
		
		
		tcData = CommonMethodsTest2.readDataFromTC("tc2");

		System.out.println(tcData.get("Label1"));
		System.out.println(tcData.get("Label2"));
		System.out.println(tcData.get("Label3"));
		System.out.println(tcData.get("Label4"));
		System.out.println(tcData.get("Label5"));
		System.out.println(tcData.get("Label6"));
		System.out.println(tcData.get("Label7"));
		System.out.println(tcData.get("Label8"));
		System.out.println(tcData.get("Label9"));
		System.out.println(tcData.get("Label10"));
		System.out.println();

		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}
}

