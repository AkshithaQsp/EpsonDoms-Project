package com.Epsondoms.Excelfilelibrary;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Provides To Read The Data From The ExcelFile
 *
 * 
 * @author Kallem Akshitha
 * */
public class ReadExcelFile {
	public static  FileInputStream fis = null;
	public static Workbook wb = null;
	public static FileOutputStream fos = null;

	public static String readSingleData(String sheetname, int row, int cell) {

		// 1. Convert Physical File into Java Readable
		try {
		
				fis = new FileInputStream("./src/test/resources/TestData/EmpDetails.xlsx");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

		// 2.Create the workbook using Workbook factory
		try {

			wb = WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException | IOException e) 
		{
			e.printStackTrace();
		}

		// 3.Using WorkBook get the sheet control
		String data = wb.getSheet(sheetname).getRow(0).getCell(0).getStringCellValue();
		return data;

		// 4.Using sheet get the Row control
		// 5.Using Row Get the Cell/Column Control
		// 6.Using Cell/Column get the Cell data
	}
/**
 * This Method Is Used to Read The MultipleData From the Excel File
 * 
 * @param String sheetname,int row
 * @return void*/	

	public static void readMultipleData(String sheetname,int row) {
		// 1. Convert Physical File into Java Readable
		try {
			fis = new FileInputStream("./src/test/resources/TestData/EmpDetails.xlsx");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		// 2.Create the workbook using Workbook factory
		try {

			wb = WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.Using WorkBook get the sheet control
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		for(int i=1;i<rowcount;i++) {
			String data = wb.getSheet("sheetname").getRow(1).getCell(1).getStringCellValue();

		}
	
		
		// 4.Using sheet get the Row control
		// 5.Using Row Get the Cell/Column Control
		// 6.Using Cell/Column get the Cell data
	}
	/**
	 * This Method Is Used to Write the Data in the Excel File
	 * 
	 * @param String sheetname,int row, int cell, String data
	 * @return void*/	

	public static void writeData(String sheetname, int row, int cell, String data) {
		// Convert Physical File into Java Readable
		try {
			fis = new FileInputStream("./src/test/resources/TestData/EmpDetails.xlsx");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		// 2.Create the workbook using Workbook factory
		try {

			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.Using WorkBook get the sheet control
		wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("String data we will pass");
		// 4.Using sheet get the Row control
		// 5.Using Row Create the Column
		// 6.Using Column Set the Cell data

		// 7.Convert java Readable file into Physical File
		try {
			fos = new FileOutputStream("./src/test/resources/TestData/EmpDetails.xlsx");
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 8. Write the data
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 9.close the workbook
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
