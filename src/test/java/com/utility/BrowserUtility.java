package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtility.getLogger(this.getClass());

	
	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set( new ChromeDriver());
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching the browser on :"+browserName);
		if (browserName == Browser.CHROME) {
			driver.set( new ChromeDriver());
		}
		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			logger.error("Invalid Browser Name , Please pass the right browser!!!");
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadLess) {
		logger.info("Launching the browser on :"+browserName);
		
		if (browserName == Browser.CHROME) {
			ChromeOptions options = new ChromeOptions();
			if(isHeadLess) {
				logger.info("Launching the browser on headless mode");
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,080");
			}
			
			driver.set( new ChromeDriver(options));
		}
		
		else if (browserName == Browser.EDGE) {
			EdgeOptions options= new EdgeOptions();
			if(isHeadLess) {
				logger.info("Launching the browser on headless mode");
				options.addArguments("--headless");
				options.addArguments("-disable-gpu");
			}
			driver.set(new EdgeDriver(options));
		}
		
		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			FirefoxOptions options= new FirefoxOptions();
			if(isHeadLess) {
				logger.info("Launching the browser on headless mode");
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,080");
			}
			driver.set(new EdgeDriver());
		}
		else {
			logger.error("Invalid Browser Name , Please pass the right browser!!!");
			System.err.print("Invalid Browser Name , Please pass the right browser!!!");
		}
		
	}

	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void goToWebsite(String url) {
		logger.info("Visiting the website :"+url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the Browser Window");
		driver.get().manage().window().maximize();
	}
	
	public void enterText(By locator,String textToEnter) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
		logger.info("Element Found and entering text as :"+textToEnter);

	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
		logger.info("Element found an performing click operation");

	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the Locator :"+locator);
		WebElement element = driver.get().findElement(locator);
		String text = element.getText();
		logger.info("Element found and getting the text of WebElement :"+text);
		return text;
	}
	
	public String getScreenShot(String methodName) {
		TakesScreenshot screenshot =((TakesScreenshot) driver.get());
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String filepath ="./screenshots/screenshot_"+methodName+"_"+System.currentTimeMillis()+".png";
		File file = new File(filepath);
		try {
			FileUtils.copyFile(screenshotData, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filepath;
	}
	
	
	public void quit() {
		driver.get().quit();
	}
	

}
