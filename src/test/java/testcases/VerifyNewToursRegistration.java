package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.NewToursHomePage;
import pages.RegistrationPageNewTour;

public class VerifyNewToursRegistration {

	WebDriver driver;

	NewToursHomePage newtours;

	RegistrationPageNewTour reg;

	@BeforeMethod
	public void setup() throws IOException {

		driver = Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();

		newtours = new NewToursHomePage(driver);
		reg = new RegistrationPageNewTour(driver);

	}

	@Test(dataProvider = "registration")

	public void VerifyRegistration(String firstName, String lastName, String phone, String email) {

		newtours.clickonRegistrationLInk();
		reg.getFirstnametextfield().sendKeys(firstName);
		reg.getLastnametextfield().sendKeys(lastName);
		reg.getPhonenumber().sendKeys(phone);
		reg.getEmail().sendKeys(email);

	}

	@Test

	@AfterMethod

	public void teardown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.getScreenshot(driver, result.getName());
		}

		// driver.quit();
	}

	@DataProvider(name = "registration")
	public String[][] regdataprovider() {
		String[][] regis = { { "sachin", "tendulkar", "546478", "sachin@email.com" } };
		return regis;

	}
}
