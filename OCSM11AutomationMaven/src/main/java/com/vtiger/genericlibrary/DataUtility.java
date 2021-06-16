package com.vtiger.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.PROPERTIES_PATH);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws IOException {
		FileInputStream fis1 = new FileInputStream(IAutoConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis1);
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));
	}
}









