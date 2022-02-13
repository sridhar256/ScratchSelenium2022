package regression.com;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;;
 
public class CreatingLogs
{
	ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
     
    @BeforeTest
    public void config()
    {
       htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
     
    @Test
    public void logsGeneration()
    {
        test = extent.createTest("logsGeneration");
        test.log(Status.INFO, MarkupHelper.createLabel("123 createTest() method will return the ExtentTest object", ExtentColor.GREEN));
        test.log(Status.INFO, MarkupHelper.createLabel("123 I am in actual Test", ExtentColor.RED));
      
    }
     
    @AfterTest
    public void tearDown()
    {
        extent.flush();
    }
}
