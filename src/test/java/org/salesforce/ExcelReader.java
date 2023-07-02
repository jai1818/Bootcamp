package org.salesforce;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {


		XSSFWorkbook work=new XSSFWorkbook("./Data/Accounts.xlsx");
		XSSFSheet sheetAt = work.getSheetAt(0);

		int lastRowNum = sheetAt.getLastRowNum();

		for (int i = 0; i <= lastRowNum; i++) {

			XSSFRow row = sheetAt.getRow(i);
			int lastCellNum = row.getLastCellNum();

			for (int j = 0; j < lastCellNum; j++) {

				XSSFCell cell = row.getCell(j);



				String cellValue = "";
				if (cell.getCellType() == CellType.STRING) {
					cellValue = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.NUMERIC) {
					cellValue = String.valueOf(cell.getNumericCellValue());
				} else if (cell.getCellType() == CellType.BOOLEAN) {
					cellValue = String.valueOf(cell.getBooleanCellValue());
				} else if (cell.getCellType() == CellType.FORMULA) {
					cellValue = cell.getCellFormula();
				}
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}



	}

}



