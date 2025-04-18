package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.ConfigPojo;
import com.ui.pojo.Environment;

public class JsonUtil {

	
	public static Environment readJSON(Env env) {
		
		File jsonFile = new File(System.getProperty("user.dir")+"//config//config.json");
		FileReader jsonfilereader = null;
		Gson gson = new Gson();
		ConfigPojo config;
		String envName = null;
		Environment environment;
		try {
			jsonfilereader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		config = gson.fromJson(jsonfilereader, ConfigPojo.class);
		envName = env.toString();
		environment = config.getEnvironments().get(envName);
		
		return environment;
		
	}
	
}
