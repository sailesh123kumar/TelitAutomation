package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env,String propertyName) {
		File propFile = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		FileReader readProp;
		Properties prop;
		String value = null;
		
		try {
			
			readProp = new  FileReader(propFile);
			prop = new Properties();
			prop.load(readProp);
			value = prop.getProperty(propertyName.toUpperCase());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	
	
}
