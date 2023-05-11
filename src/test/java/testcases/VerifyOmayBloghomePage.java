package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyOmayBloghomePage {


	WebDriver driver;
	HomePage homepage;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		
		driver=Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		homepage =new HomePage(driver);
	}
	
	@Test(priority = 1,groups = {"e2e"},enabled=true)
	public void VerifyOmayBloghomePage() throws IOException {
		
		//Verify user is on omayo home page
		assertEquals( homepage.getPagetitle().getText(),"omayo (QAFox.com)");
		//Utility.getScreenshot(driver, "snap_"+System.currentTimeMillis());
		
		String value="doc 1";
		//verify that value is selected from dropDown
		Utility.selectValueFromaDropdown(homepage.getdropDown(), value);
	
		assertEquals(homepage.getValueSelectedInDropdown(), value);
		
		//make sure image is displayed at left upper side
		
		assertTrue(homepage.getCollegeImage().isDisplayed());
		
		//verify table contents from user table
		List<String> expectedTableData=new ArrayList<String>();
		
		expectedTableData=Arrays.asList("Kishore","22","Delhi","Manish","25","Pune","Praveen","29","Bangalore","Dheepthi","31","Mumbai");
		
		assertTrue(homepage.getTableData().equals(expectedTableData));
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
		//it will close all tab 
		driver.quit();
	}
}
