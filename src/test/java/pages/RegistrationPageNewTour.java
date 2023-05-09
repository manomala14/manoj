package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageNewTour {

	WebDriver driver;

	WebElement firstnametextfield;
	WebElement Lastnametextfield;
	WebElement phonenumber;
	WebElement email;

	public RegistrationPageNewTour(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getFirstnametextfield() {
		setFirstnametextfield();
		return firstnametextfield;
	}

	public void setFirstnametextfield() {
		this.firstnametextfield = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastnametextfield() {
		setLastnametextfield();
		return Lastnametextfield;
	}

	public void setLastnametextfield() {
		Lastnametextfield = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getPhonenumber() {
		setPhonenumber();
		return phonenumber;
	}

	public void setPhonenumber() {
		this.phonenumber = driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement getEmail() {
		setEmail();
		return email;
	}

	public void setEmail() {
		this.email = driver.findElement(By.xpath("//input[@name='userName']"));
	}

}
