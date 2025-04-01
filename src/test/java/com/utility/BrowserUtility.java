package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private WebDriver driver;
	
	public BrowserUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}
	
	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		else if (browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
		else {
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}

	
	public WebDriver getDriver() {
		return driver;
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
	
	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
	

}
