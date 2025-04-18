package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSV(String fileName) {
		
		File file = new File(System.getProperty("user.dir")+"//testData//"+fileName+".csv");
		FileReader reader;
		CSVReader csvReader;
		String[] line;
		List<User> userData = null ;
		User user;
		try {
			reader = new FileReader(file);
			csvReader = new CSVReader(reader);
			csvReader.readNext();
			
			userData = new ArrayList<User>();
			while((line=csvReader.readNext())!=null) {
				user = new User(line[0], line[1]);
				userData.add(user);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException  | IOException e) {
			e.printStackTrace();
		}
		return userData.iterator();
	}

}
