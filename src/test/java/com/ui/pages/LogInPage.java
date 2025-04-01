package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LogInPage extends BrowserUtility {

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR =  By.id("SubmitLogin");
	
	public AccountPage doLogInWith(String email, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new AccountPage(getDriver());
	}

}
