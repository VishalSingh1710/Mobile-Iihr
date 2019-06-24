package ExcelDataConfig;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfigClass {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataConfigClass(String excelPath){

		try {
			File src = new File("/home/zolipe/Desktop/Vishal/AutomationExcel/Excel/TestData.xlsx");

			FileInputStream fls = new FileInputStream(src);

			///////////////For xlsx file
			wb = new XSSFWorkbook(fls);

			////////////////For xls file
			//HSSFWorkbook hb = new HSSFWorkbook(fls);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}
	
	public String getData(int sheetnumber, int row, int column){
		
		sheet1 = wb.getSheetAt(sheetnumber);
		
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
		
	}
	
	
}