package com.ui.test;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class BaseTest {
	
	protected HomePage homePage;
    protected Logger logger = LoggerUtility.getLogger(this.getClass());

	
	@BeforeMethod(description = "To Load the HomePage WebSite")
	public void setUp() {
		logger.info("Loads the HomePage WebSite");
		homePage =new HomePage(CHROME);
	}
	
	public BrowserUtility getinstance() {
		return homePage;
	}

}
