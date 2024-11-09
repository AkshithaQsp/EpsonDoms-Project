package com.Epsondoms.Propertyfilelibrary;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class Provides The Resuable Methods To Read The Data from PropertyFile
 * 
 * 
 * @author Kallem Akshitha
 * */

import com.Epsondoms.Genericlibrary.FrameWorkConstant;

public class ReadPropertyFile implements FrameWorkConstant{
	public static  FileInputStream fis;
	public static Properties property;
	public static FileOutputStream fos;
	
	/**
	 * This Method is Used to Read the Data From PropertyFile
	 * @param String key
	 * @return String*/

	public static String readData(String key) {

		// 1.Convert the physical file into Java Readable

		try {
			fis = new FileInputStream("./src/test/resources/TestData/commondata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an object for Properties class
		property = new Properties();

		// 3.Load all the keys datas
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 4.Fetch the data
		String data = property.getProperty(key);
		return data;

	}
	/**
	 * This Method is Used to Write the Data From PropertyFile
	 * @param String key, String value
	 * @return void*/
	
	public static void writeData(String key, String value) {
		//// 1.Convert the physical file into Java Readable

		try {
			fis = new FileInputStream("./src/test/resources/TestData/commondata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an object for Properties class
		property = new Properties();

		// 3.Load all the keys Datas
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4.Write the Data

		property.put(key, value);

		// 5.Convert java Readable into Physical file

		try {
			fos = new FileOutputStream("./src/test/resources/TestData/commondata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 6.Store the Data
		try {
			property.store(fos, "Latest Key Upadated Sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
