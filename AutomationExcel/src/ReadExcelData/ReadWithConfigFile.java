package ReadExcelData;

import ExcelDataConfig.ExcelDataConfigClass;

public class ReadWithConfigFile {

	public static void main(String[] args) {

		ExcelDataConfigClass excel = new ExcelDataConfigClass("/home/zolipe/Desktop/Vishal/AutomationExcel/Excel/TestData.xlsx");
		System.out.println(excel.getData(1,0,1));
	}
}
