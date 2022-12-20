package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public String readDataFromExcel(String SheetNum, int rowNum, int cellNUm) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./ZooManagement.xlsx");
		Workbook workBook = WorkbookFactory.create(fileInputStream);
		Sheet sheetName = workBook.getSheet(SheetNum);
		Row rowNumber = sheetName.getRow(rowNum);
		Cell cellNumber = rowNumber.getCell(cellNUm);
		String value=cellNumber.getStringCellValue();
		return value;
	}
	public int getIntlastRowCount(String sheetName) throws Throwable  {
		FileInputStream fileInputStream = new FileInputStream("/ZooManagement.xlsx");
		Workbook workBook = WorkbookFactory.create(fileInputStream);
		return workBook.getSheet(sheetName).getLastRowNum();
	}

}
