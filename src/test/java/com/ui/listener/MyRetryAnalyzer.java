package com.ui.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtil;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	//private static final int MAX_NUMBER_OF_ATTEMPTS = 3;
	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtil.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	
	int currentAttempt = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		
		return false;
	}
	

}
