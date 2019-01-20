package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}

	public static void main(String[] args) throws IOException {

	}

	public int getRowCount() throws IOException {

		int row = sheet.getPhysicalNumberOfRows();
		//System.out.println("No. of rows" + row);
		return row;

	}
	
	public int getColumnCount() {
		
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("No. of column" +column);
		return column;
		
	}

	public String getCellString(int rowNum, int cellNum) throws IOException {

		String firstName = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		//System.out.println(firstName);
		
		return firstName;

	}

	public double getCellNumeric(int rowNum, int cellNum) throws IOException {

		double phoneDetails = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		//System.out.println(phoneDetails);
		return phoneDetails;

	}
}
