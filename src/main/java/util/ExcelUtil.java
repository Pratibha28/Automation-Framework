package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static String TESTDATA_SHEET_PATH=System.getProperty("user.dir")
			+"//src//main//java//testdata"
			+ "//GoogleLoginNew.xlsx";

	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		try {
			FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);

			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
			
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum(); i++){
				for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					System.out.print(data[i][k]+"--");
					
				}
			}
			
			return data;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}



}
