package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class AccountPage extends BrowserUtility {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchForAProduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		return new SearchResultPage(getDriver());
		
	}
}
