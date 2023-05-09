package com.param.project;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Taste case started"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Taste case succedd"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		Reporter.log("Taste case failed"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Taste case skipped"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
		

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
