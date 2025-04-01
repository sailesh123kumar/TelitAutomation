package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility {

	public HomePage(Browser browserName) {
		super(browserName);   //To call the parent class constructor
		goToWebsite("https://www.automationpractice.pl/index.php?");
		maximizeWindow();

	}
	
	
	private final static By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public LogInPage goToLogInPage() {
		clickOn(SIGN_IN_LOCATOR);
		return new LogInPage(getDriver());
	}

}
