package com.utility;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	private static ExtentSparkReporter extentSparkReporter;
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	
	public static void setUpReport(String reportName) {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName);
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createTest(String name) {
		ExtentTest test = extentReports.createTest(name);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
	

}
