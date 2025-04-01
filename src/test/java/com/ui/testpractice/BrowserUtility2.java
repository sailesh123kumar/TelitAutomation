package com.ui.testpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtility2 {
	
	private WebDriver driver;
	
	public BrowserUtility2(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void enterText(By locator,String textToEnter) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}
	

}
