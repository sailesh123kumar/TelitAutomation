package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelUtility {

	public static Iterator<User> readExcel(String fileName) {

		File file = new File(System.getProperty("user.dir") + "//testData//logInTestData.xlsx");
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		XSSFCell cell;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddress;
		Cell password;
		List<User> userData = null;
		User user;

		try {
			workBook = new XSSFWorkbook(file);
			sheet = workBook.getSheet("logInTestData");
			rowIterator = sheet.iterator();
			rowIterator.next();
			userData = new ArrayList<User>();
			
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddress = row.getCell(0);
				password = row.getCell(1);
				user = new User(emailAddress.toString(), password.toString());
				userData.add(user);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userData.iterator();

	}

}
