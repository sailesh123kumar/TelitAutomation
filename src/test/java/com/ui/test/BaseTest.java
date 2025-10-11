package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.utility.LambdaTestUtility;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class BaseTest {
	
	protected HomePage homePage;
    protected Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest ;
	
    @Parameters({"browser","isHeadLess","isLambdaTest"})
	@BeforeMethod(description = "To Load the HomePage WebSite")
	public void setUp(
			@Optional("chrome") String browser , 
			@Optional("true") boolean isHeadless, 
			@Optional("false") boolean isLambdaTest , ITestResult result) {
    	this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}
		else {
			logger.info("Loads the HomePage WebSite");
			homePage =new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	public BrowserUtility getinstance() {
		return homePage;
	}
	
	
	@AfterMethod
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			homePage.quit();
		}
	}

}
