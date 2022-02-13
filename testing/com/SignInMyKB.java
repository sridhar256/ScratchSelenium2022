package testing.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInMyKB {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.kbhome.com/");
	}
	
	@Test
	public void SignInMyKB() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement signin = driver.findElement(By.id("mykb"));
		js.executeScript("arguments[0].click()", signin);
		Reporter.log("User is able to click on 'SIGN IN' with PASS Status");
		Thread.sleep(2000);
		
		WebElement signin1 = driver.findElement(By.xpath("//a[@id='create-account']"));
		js.executeScript("arguments[0].click()", signin1);
		Reporter.log("User is able to click on 'SIGN IN' with PASS Status");
		Thread.sleep(2000);

			
		WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		js.executeScript("arguments[0].value = 'Sreedhar';", firstName);
		Reporter.log("User is able to input 'Sreedhar' in 'First Name' field with PASS Status");
		Thread.sleep(2000);


		WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
		js.executeScript("arguments[0].value = 'Jasti';", lastName);
		Reporter.log("User is able to input 'Jasti' in 'Last Name' field with PASS Status");
		Thread.sleep(2000);

	
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		js.executeScript("arguments[0].value = 'sreedhar@stellaragency.com';", email);
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in 'Email' field with PASS Status");
		Thread.sleep(2000);

		
		WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='ConfirmEmail']"));
		js.executeScript("arguments[0].value = 'sreedhar@stellaragency.com';", confirmEmail);
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in 'Confirm Email' field with PASS Status");
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//input[@title='password']"));
		js.executeScript("arguments[0].value = 'bitlabs123*';", password);
		Reporter.log("User is able to input 'bitlabs123*' in 'Passoword' field with PASS Status");
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
		dropdownSelection.selectByValue("3");
		Reporter.log("User is able to select 'Terms and Conditions' checkbox field with PASS Status");
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement communityList = driver.findElement(By.xpath("//select[@id='CommunityList']"));
		Select dropdownSelection1 = new Select(communityList);
		dropdownSelection1.selectByValue("01400704");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement personalDescription = driver.findElement(By.xpath("//select[@id='RegistrationType']"));
		Select dropdownSelection2 = new Select(personalDescription);
		dropdownSelection2.selectByValue("shopper");
		
		WebElement createProfile = driver.findElement(By.xpath("//input[@id='RegSubmit']"));
		js.executeScript("arguments[0].click()", createProfile);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
