package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	
	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName,String sheetName, int rowNo, int cellNo) throws IOException
	{
		
		
		try 
		{
			inputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstream);
			sheet = workbook.getSheet(sheetName);
			cell=workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
			
		}
		catch (Exception e) 
		{
			return "";
		}	
	}
	
	public static int getRowCount(String fileName, String sheetName) throws IOException
	{
		
		try 
		{
			inputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstream);
			sheet = workbook.getSheet(sheetName);
			int ttlRow = sheet.getLastRowNum()+1;
			workbook.close();
			
			return  ttlRow;
		} 
		catch (Exception e) 
		{
			return 0;
		}
		
		
	}
	
	public static int getColCount(String fileName, String sheetName)
	{
		try 
		{
		FileInputStream inputstream = new FileInputStream(fileName);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int ttlCell = sheet.getRow(0).getLastCellNum();
		workbook.close();
		
		return  ttlCell;
		
		} 
		catch (Exception e) 
		{
			return 0;
		}
		
		
	}
	
	
	
	

}
