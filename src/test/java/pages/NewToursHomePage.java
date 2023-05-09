package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	WebDriver driver;
	
	WebElement registrationlink;
	
	
	public NewToursHomePage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement getRegistrationlink() {
		setRegistrationlink();
		return registrationlink;
	}

	public void setRegistrationlink() {
		this.registrationlink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	}
	
	public void clickonRegistrationLInk() {
		
		getRegistrationlink().click();
	}
}
