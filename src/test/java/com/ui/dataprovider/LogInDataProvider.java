package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelUtility;

public class LogInDataProvider {
	
	@DataProvider(name="logInJSONTestData")
	public static Iterator<Object[]> logInJSONDataProvider() {
		File loginDataFile = new File(System.getProperty("user.dir")+"//testData//loginTestData"+".json");
		FileReader loginFileReader = null;
		Gson gson = new Gson();
		TestData testData = null;
		List<Object[]> dataToReturn;
		
		try {
			loginFileReader = new FileReader(loginDataFile);
			testData = gson.fromJson(loginFileReader, TestData.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		dataToReturn = new ArrayList<Object[]>();
		
		for(User userData:testData.getData()) {
			dataToReturn.add(new Object[] {userData});
		}
		
		return dataToReturn.iterator();
		
	}
	
	@DataProvider(name="logInCSVTestData")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSV("logInTestData");
	}
	
	@DataProvider(name="logInExcelTestData")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelUtility.readExcel("logInTestData");
	}

}
