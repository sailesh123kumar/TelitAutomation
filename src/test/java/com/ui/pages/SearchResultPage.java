package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	
	public String searchResultPageTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

}
