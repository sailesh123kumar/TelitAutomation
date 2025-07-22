package com.ui.listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.pages.HomePage;
import com.ui.test.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	
    Logger logger = LoggerUtility.getLogger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		logger.info (result.getMethod().getMethodName());
		logger.info (result.getMethod().getDescription());
		logger.info (Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info (result.getMethod().getMethodName()+ " " +"PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+ " " +"PASSED");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info (result.getMethod().getMethodName()+ " " +"FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+ " " +"FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((BaseTest)testclass).getinstance();
		
		logger.info ("Capturing Screenshot for failed test");
		String screenShotPath = browserUtility.getScreenShot(result.getMethod().getMethodName());
		logger.info ("Attaching Screenshot to the HTML file");

		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenShotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn (result.getMethod().getMethodName()+ " " +"SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+ " " +"SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started...");
		ExtentReportUtility.setUpReport("report_"+System.currentTimeMillis()+".html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed!!!");
		ExtentReportUtility.flushReport();

	}
	
	

}
