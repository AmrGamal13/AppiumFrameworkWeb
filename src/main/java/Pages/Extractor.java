package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Extractor {

	private static XSSFWorkbook xssfWorkbook;
	private static FileInputStream fileInputStream;
	String fileName = "Test_Data_Mobile.xlsx";
	ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	//File src = new File(classLoader.getResource(fileName).getFile());
	//File src = new File(("user.dir")+"page_Object_Assessment/AutomationTest.xlsx");
	File src = new File("/Users/adelmostafa/Documents/tryappiumnew/resources/Test_Data_Mobile.xlsx");
	public Extractor() throws IOException {
		fileInputStream = new FileInputStream(src);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
	}

	public String[] CredentialsLoader() throws Exception {
		String[] elementCssSelectors = new String[2];
		int count = 1;
		XSSFSheet sheet0 = xssfWorkbook.getSheetAt(0);
		elementCssSelectors[0] = sheet0.getRow(count).getCell(0).getStringCellValue();
		elementCssSelectors[1] = sheet0.getRow(count).getCell(1).getStringCellValue();
		return elementCssSelectors;
	}
	
	public String Locaters(int sheetNumber, int RowNumber) throws Exception {
        String ColorsCSS = "";
        XSSFSheet sheet1 = xssfWorkbook.getSheetAt(sheetNumber);
        int i;
        // System.out.println(sheet1.getRow(RowNumber).getLastCellNum());
        for (i = 0; i < sheet1.getRow(RowNumber).getLastCellNum() - 1; i++) {
            String value = sheet1.getRow(RowNumber).getCell(i+1).getStringCellValue();
            if(value.equals(""))
                break;
            else
                ColorsCSS = value;
        }
        return ColorsCSS;
    }
}
