package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utils.DriverUtils;

public class MyListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"test case Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		//Screen Shot lean h after fail
		test.log(Status.FAIL,"test case Passed");
		String path=DriverUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,"test case Passed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
	} 

}
