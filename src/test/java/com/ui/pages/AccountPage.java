package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class AccountPage extends BrowserUtility {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}
}
