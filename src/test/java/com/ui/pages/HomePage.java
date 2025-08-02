package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtil;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);   //To call the parent class constructor
		//goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JsonUtil.readJSON(QA).getUrl());
		maximizeWindow();

	}
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtil.readJSON(QA).getUrl());
		maximizeWindow();
	}


	private final static By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public LogInPage goToLogInPage() {
		logger.info("Trying to Perform click to go to sign in page");
		clickOn(SIGN_IN_LOCATOR);
		return new LogInPage(getDriver());
	}

}
