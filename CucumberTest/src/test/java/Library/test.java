package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import Library.KeyWordLibrary;
import Util.ExcelUtil;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targetRow = 0;
		String TestCase_ID="Test_ID_001";
		String ExcelPath=ExcelUtil.getPath("DataRepositoryPath");
		String ExcelName=ExcelUtil.getPath("DataExcelName");
		String ExcelSheet=ExcelUtil.getPath("DataExcelSheet");
		System.out.println("Excel path: "+ExcelPath+"\\"+ExcelName);
	    File file =  new File("src\\TestData\\TestData.xls");	
	    try {
	    	 
	   
	    //Create an object of FileInputStream class to read excel file		 
	    FileInputStream inputStream = new FileInputStream(file);
	    System.out.println("Excel path: "+ExcelPath+"\\"+ExcelName);
	    Workbook oWorkBook = new HSSFWorkbook(inputStream);
		 Sheet oSheet = oWorkBook.getSheet(ExcelSheet);	
		 
		 Integer rowCount=oSheet.getLastRowNum();
		 System.out.println("Row totoal:"+rowCount);
		 for (int i = 1; i < rowCount+1; i++) {
			 Row Row=oSheet.getRow(i);
			 Cell cell=Row.getCell(1);
			 String Test_ID=cell.getStringCellValue();
			 System.out.println(Test_ID+":"+TestCase_ID);
			 if (Test_ID.toUpperCase().trim().equals(TestCase_ID.toUpperCase().trim())){
				 targetRow=i;
				 break;
			 }
		 }
		 Row row = oSheet.getRow(targetRow);
			Row headerRow=oSheet.getRow(0);
			for (int j = 0; j < row.getLastCellNum(); j++) {
	             
			     Cell cell = row.getCell(j);
			     Cell headerCell=headerRow.getCell(j);
			     if (headerCell.getStringCellValue().toUpperCase().trim().equals("Password")) {
				     switch(cell.getCellType()) {
			           case Cell.CELL_TYPE_BOOLEAN:
			               System.out.println(cell.getBooleanCellValue());
			               
			            case Cell.CELL_TYPE_NUMERIC:
			                System.out.println(cell.getNumericCellValue());
			            case Cell.CELL_TYPE_STRING:
			                System.out.println(cell.getStringCellValue());
			            }
				     break;
			     }

			  }
		
		
	}
	 catch(IOException e) {
		
	    e.printStackTrace();
	 }
	}
	}


