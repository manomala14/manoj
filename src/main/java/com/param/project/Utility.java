package com.param.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	public static WebDriver getDriver() {
		
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static String getProperty(String key) throws IOException {
		
		File file=new File("src/test/resources/data.properties");
		FileInputStream fileinput=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileinput);
		return properties.getProperty(key);
	}
	
	public static void getScreenshot(WebDriver driver,String screenshotname) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src/test/resources/screenshot/"+screenshotname+".png"));
		
	}
	
	public static List<String> readExcel() throws IOException
	{
		File file=new File("src/test/resources/Registration.xls");
		
		FileInputStream filein=new FileInputStream(file);
		
		List<String> userRegistrationDetails=new ArrayList<String>();
		
		//reading .xls file
		HSSFWorkbook hss=new HSSFWorkbook(filein);
		
		HSSFSheet sheet=hss.getSheetAt(0);
		
	int	rownum=sheet.getLastRowNum();
	
	for(int i = 1;i<= rownum;i++)
	{
	HSSFRow	row=sheet.getRow(i);
	
	int cell=row.getLastCellNum();
	
	for(int j = 0;j<cell;j++) {
		
		userRegistrationDetails.add(row.getCell(j).getStringCellValue());
	}
	

	}
	
	return userRegistrationDetails;
	}
	
	public static void selectValueFromaDropdown(WebElement dropdown,String valueToSelect) {
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(valueToSelect);
	}
	
	
	

	

}
