package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import Library.KeyWordLibrary;
public class ExcelUtil extends KeyWordLibrary{
	Workbook oWorkbook;
	Sheet oSheet;
	static Properties Pathproperties;
//	public HashMap<String, ?> ReadExcelRow(String Conditions) throws IOException{
//		String ExcelPath=getPath("DataRepositoryPath");
//		String WorkBookName=getPath("DataExcelName");
//		String SheetName=getPath("DataExcelSheet");
//		File file =    new File(ExcelPath+"\\"+WorkBookName);
//		FileInputStream inputStream = new FileInputStream(file);		
//		oWorkbook = new HSSFWorkbook(inputStream);
//		oSheet = oWorkbook.getSheet(SheetName);
//		int slectedRow=getRow(oSheet,Conditions);
//		//////Create hashmap
//		System.out.println("selected Row is "+slectedRow);
//		return null;
//	}
//	public static final String path="src\\test\\resources\\path.properties";

	/*function:getPath(String strPathName)
	 * Used to fetch path from path.properties file
	 * return : String value of path
	 */
//	public static String getPath(String strPathName) {		
//		Pathproperties = new Properties();
//	      try {
//	      FileInputStream Master = new FileInputStream(path);
//	      Pathproperties.load(Master);
//	      Master.close();
//	          }catch (IOException e) {
//	           System.out.println(e.getMessage());
//	         }
//	      return Pathproperties.getProperty(strPathName);
//	}
	
	
	public static Integer getColNumber(Sheet trgSheet,String strColName){
		Row headerRow=trgSheet.getRow(0);
//		System.out.println(headerRow.getLastCellNum());
		for(int j = 0; j < headerRow.getLastCellNum(); j++){
			Cell cell = headerRow.getCell(j);
			System.out.println(cell.getStringCellValue().equalsIgnoreCase(strColName));
			if (cell.getStringCellValue().equalsIgnoreCase(strColName)){
				return j;
			}
		}
		System.out.println("Column with column name '"+strColName+"' not found");
		return null;
	}
	
	
	public Integer getRow(Sheet trgSheet,String Conditions){
//		Row headerRow=oSheet.getRow(0);
		//Break all the conditions
		String[] totalCond=Conditions.split(":");
		Integer currentRow=0;
		int iRow=0;
		int rowCount = trgSheet.getLastRowNum()-trgSheet.getFirstRowNum();
		for(String condition:totalCond){
			String colName=condition.split(":")[0];
			String colVal=condition.split(":")[1];
			Integer colNum=getColNumber(trgSheet,colName);
			for (iRow=currentRow;iRow<rowCount;iRow++){
				Row row=trgSheet.getRow(iRow);
				Cell cell = row.createCell(colNum);
				if(cell.getStringCellValue().equalsIgnoreCase(colVal)){
					currentRow=iRow;
				}
			}
			if(iRow==rowCount){
				System.out.println("Column value '"+colVal+"' for Column '"+colName+"' not present in sheet");
				break;
			}
		}

		
		return iRow;
	}
	
	
	@SuppressWarnings("deprecation")
	public static Dictionary<String, Comparable> getDictionary(Sheet oSheet, int intRow){

		Dictionary<String, Comparable> dict= new Hashtable<String, Comparable>();
			Row row = oSheet.getRow(intRow);
			Row headerRow=oSheet.getRow(0);
			//For each row, iterate through each columns
			for (int j = 0; j < row.getLastCellNum(); j++) {
			             
			     Cell cell = row.getCell(j);
			     Cell headerCell=headerRow.getCell(j);
			     switch(cell.getCellType()) {
			           case Cell.CELL_TYPE_BOOLEAN:
			               dict.put(headerCell.getStringCellValue(), Boolean.toString((Boolean) cell.getBooleanCellValue()));
//			               System.out.println(cell.getBooleanCellValue());
			               break;
			            case Cell.CELL_TYPE_NUMERIC:
			                dict.put(headerCell.getStringCellValue(), Integer.toString((int) cell.getNumericCellValue()));
//			                System.out.println(cell.getNumericCellValue());
			                break;
			            case Cell.CELL_TYPE_STRING:
			                dict.put(headerCell.getStringCellValue(),cell.getStringCellValue());
//			                System.out.println(cell.getStringCellValue());
			                 break;
			            }
			  }
			return dict;
		   }


	
	public static Dictionary getTestData(String filePath,String fileName,String sheetName,String strTestName) throws FileNotFoundException{
		Integer rowNumber = null;
		
		 //Create a object of File class to open xls file		 
	    File file =    new File(filePath+"\\"+fileName);		 
	    //Create an object of FileInputStream class to read excel file		 
	    FileInputStream inputStream = new FileInputStream(file);	
	    try {
			Workbook oWorkBook = new HSSFWorkbook(inputStream);
			 Sheet oSheet = oWorkBook.getSheet(sheetName);	
			 Integer rowCount=oSheet.getLastRowNum();
//			 System.out.println("colNumber:"+rowCount);
			 Integer testNameColumn=getColNumber(oSheet,"Test_Case");
			 
//			 Integer deviceColumn=getColNumber(oSheet,"Device");
			
			 
			 
			  for (int i = 1; i < rowCount+1; i++) {
				 Row Row=oSheet.getRow(i);			 
				 int lastCol=Row.getLastCellNum();
				 Cell cell=Row.getCell(testNameColumn);
				 String TestNameVal=cell.getStringCellValue();
				 if (TestNameVal.toUpperCase().trim().equals(strTestName.toUpperCase().trim())){
//					 Cell DeviceCell=Row.getCell(deviceColumn);
//					 String DeviceVal=DeviceCell.getStringCellValue();
//					 if (DeviceVal.toUpperCase().trim().equals(DeviceName.toUpperCase().trim())){
						 Dictionary testDataDict=getDictionary(oSheet,i);
//						 return testDataDict;
//					 }
					 return testDataDict;
				 }
			 }
		        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return null;
		
	}
	public static String Get(String TestCase_ID,String Val) {
		int targetRow = 0;
		String ExcelPath=getPath("DataRepositoryPath");
		String ExcelName=getPath("DataExcelName");
		String ExcelSheet=getPath("DataExcelSheet");
		System.out.println("Excel path: "+ExcelPath+"\\"+ExcelName);
	    File file =  new File("src\\test\\java\\TestData\\TestData.xls");	
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
			 Cell cell=Row.getCell(0);
			 String Test_ID=cell.getStringCellValue();
			 if (Test_ID.toUpperCase().trim().equals(TestCase_ID.toUpperCase().trim())){
				 targetRow=i;
				 break;
			 }
		 }
		 System.out.println(targetRow);
		 Row row = oSheet.getRow(targetRow);
			Row headerRow=oSheet.getRow(0);
			for (int j = 0; j < row.getLastCellNum(); j++) {
	             
			     Cell cell = row.getCell(j);
			     Cell headerCell=headerRow.getCell(j);
			     if (headerCell.getStringCellValue().toUpperCase().trim().equals(Val.toUpperCase())) {
				     switch(cell.getCellType()) {
			           case Cell.CELL_TYPE_BOOLEAN:
			               return Boolean.toString((Boolean) cell.getBooleanCellValue());
//			               System.out.println(cell.getBooleanCellValue());
			               
			            case Cell.CELL_TYPE_NUMERIC:
			                return Integer.toString((int) cell.getNumericCellValue());
//			                System.out.println(cell.getNumericCellValue());
			            case Cell.CELL_TYPE_STRING:
			                return cell.getStringCellValue();
//			                System.out.println(cell.getStringCellValue());
			            }
				     break;
			     }

			  }
		return null;
		
	}
	 catch(IOException e) {
	    e.printStackTrace();}
		return null;
	
	
	}}
