package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.BaseClass.Testbase;

public class ExcelUtility extends Testbase {

	FileInputStream fis = null;
	Workbook wb = null;
	Sheet sh = null;

	public String getcellData(String filepath, String sheet1, int row, int column) {
		DataFormatter df = new DataFormatter();

			try {
				fis = new FileInputStream(filepath);
				wb = new WorkbookFactory().create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		sh = wb.getSheet(sheet1);
		Cell c = sh.getRow(row).getCell(column);
		return df.formatCellValue(c);
	}
	 @Test
	  public void xlsRead() {
		  String jxlpath = System.getProperty("user.dir")+"/src/test/resourses/Test.xls";
		 
		 
			  
	  }
}
