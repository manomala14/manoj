package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyApplicationHomePageTitle {
	WebDriver driver;
	HomePage homepage;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		
		driver=Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		homepage =new HomePage(driver);
	}
	@Test(priority = 1,groups = {"sanity"},enabled=true)
	public void verifyPageTitle() throws IOException {
		
		assertEquals( homepage.getPagetitle().getText(),"omayo (QAFox.com)");
		//Utility.getScreenshot(driver, "snap_"+System.currentTimeMillis());
		
	}
	
	@Test
	
	public void VerifyRegistration() {
		
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void teardown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Utility.getScreenshot(driver, result.getName());
		}
		
		driver.quit();
	}
}
