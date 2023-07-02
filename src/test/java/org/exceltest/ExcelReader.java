package org.exceltest;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	
	@DataProvider(name="credentials")
	public Object[][] excelTestDataReading() throws IOException {
		
		
		XSSFWorkbook work=new XSSFWorkbook("./Data/Accounts.xlsx");
		XSSFSheet sheetAt = work.getSheetAt(0);
		int RowNum = sheetAt.getLastRowNum();
		int ColNum = sheetAt.getRow(1).getLastCellNum();
		 
		Object[][] data = new Object[RowNum][ColNum];
		
		   for (int i = 1; i <= RowNum; i++) {
	        
	            for (int j = 0; j < ColNum; j++) {
	            	String values = sheetAt.getRow(i).getCell(j).getStringCellValue();
	              data[i-1][j]=values;
	            }
	        }
		   work.close();
		   return data;
		
		
		
		
		
		
		
		
		
	}


		
		

		

		
}



