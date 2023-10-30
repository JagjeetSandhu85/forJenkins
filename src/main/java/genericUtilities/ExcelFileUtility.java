package genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcelFile(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\7PmClassTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;

	}

	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\7PmClassTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) 
		{
			for (int j = 0; j < lastCell; j++) 
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		return data;
	}

}
