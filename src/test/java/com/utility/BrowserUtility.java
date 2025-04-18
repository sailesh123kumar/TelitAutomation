package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private WebDriver driver;
    Logger logger = LoggerUtility.getLogger(this.getClass());

	
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
		logger.info("Launching the browser on :"+browserName);
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
			logger.error("Invalid Browser Name , Please pass the right browser!!!");
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}

	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void goToWebsite(String url) {
		logger.info("Visiting the website :"+url);
		driver.get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the Browser Window");
		driver.manage().window().maximize();
	}
	
	public void enterText(By locator,String textToEnter) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.findElement(locator);
		element.sendKeys(textToEnter);
		logger.info("Element Found and entering text as :"+textToEnter);

	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.findElement(locator);
		element.click();
		logger.info("Element found an performing click operation");

	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.findElement(locator);
		String text = element.getText();
		logger.info("Element found and getting the text of WebElement :"+text);
		return text;
	}
	

}
