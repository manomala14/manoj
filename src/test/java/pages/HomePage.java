package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.page.Page.GetAppIdResponse;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	WebElement pagetitle;
	WebElement searchTextbox;
	WebElement dropDown;
	WebElement collegeImage;
	WebElement maleRadioutton;
	WebElement femaleRadioutton;
	WebElement orangecheckox;
	WebElement bluecheckbox;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPagetitle() {
		setPagetitle();
		return pagetitle;
	}
	public void setPagetitle() {
		pagetitle =driver.findElement(By.xpath("//h1[@class='title']"));
	}
	
	public WebElement getSearchTextbox() {
		SetSearchTextbox();
		return searchTextbox;
	}
	public void SetSearchTextbox() {
		this.searchTextbox = driver.findElement(By.xpath("//input[@name='q'and @title='search']"));
	}
	
	public WebElement getdropDown() {
		setdropDown();
		return dropDown;
	}

	public void setdropDown() {
		this.dropDown =driver.findElement(By.xpath("//select[@id='drop1']"));
	}

	public WebElement getCollegeImage() {
		setCollegeImage();
		return collegeImage;
	}

	public void setCollegeImage() {
		this.collegeImage =driver.findElement(By.xpath("//img[contains(@src,'college')]"));
	}

	public WebElement getMaleRadioutton() {
		setMaleRadioutton();
		return maleRadioutton;
	}

	public void setMaleRadioutton() {
		this.maleRadioutton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

	public WebElement getFemaleRadioutton() {
		setFemaleRadioutton();
		return femaleRadioutton;
	}

	public void setFemaleRadioutton() {
		this.femaleRadioutton = driver.findElement(By.xpath("//input[@id='radio2']"));
	}

	public WebElement getOrangecheckox() {
		setOrangecheckox();
		return orangecheckox;
	}

	public void setOrangecheckox() {
		this.orangecheckox =driver.findElement(By.xpath("//input[@id='checkbox1']"));
	}

	public WebElement getBluecheckbox() {
		setBluecheckbox();
		return bluecheckbox;
	}

	public void setBluecheckbox() {
		this.bluecheckbox =driver.findElement(By.xpath("//input[@id='checkbox2']"));
	}

	public void SetTextInserachTextfield(String textToSearch) {
		
		getSearchTextbox().sendKeys(textToSearch);
		
	}
	
	public boolean VerifySearchFiledisEnabled() {
		
		return getSearchTextbox().isEnabled();
	}

	public String getValueSelectedInDropdown() {
		
		Select select=new Select(getdropDown());
		return select.getFirstSelectedOption().getText();
		
	}
	
public List<String> getTableData() {
		
		ArrayList<String> table=new ArrayList<String>();
		List<WebElement> tableData=driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
		for(WebElement elm:tableData)
		{
			table.add(elm.getText());
			
		}
		return table;
		
	}

}
