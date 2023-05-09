package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class VerifyCheckboxandRadioButton {

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
		public void VerifyCheckboxesAndRadioButtonsBehav()  {
			
			//verify that male and female radio button are unchecked
			//make sure orange checkbox is checked and blue checkbox is unchecked
			
			assertFalse(homepage.getMaleRadioutton().isSelected());
			assertFalse(homepage.getFemaleRadioutton().isSelected());
			
			assertTrue(homepage.getOrangecheckox().isSelected());
			assertFalse(homepage.getBluecheckbox().isSelected());
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


