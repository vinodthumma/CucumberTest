package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;
//import org.openqa.selenium.h
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import Util.ExcelUtil;

public class SCECOM_Login {
	public static final String path="src\\com\\ProjectProperties\\path.properties";
static Dictionary DataDictionary;
static Properties testPathProp;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println();
		DataDictionary=ExcelUtil.getTestData(getPath("DataRepositoryPath"),getPath("DataExcelName"),"US9","WebUserLogin");
		String UserName=(String) DataDictionary.get("User_ID");
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://wwwsysc.sce.com");
		WebElement textbox=driver.findElement(By.xpath("//*[@id=\"fullLoginEmail\"]"));
		textbox.sendKeys(UserName);
		
		WebElement textbox1=driver.findElement(By.xpath("//*[@id=\"fullLoginPassword\"]"));
		textbox1.sendKeys("Edison123");
		
		
		WebElement Cbutton=driver.findElement(By.xpath("//*[@id=\"loginSubmitDesktopButton\"]"));
		Cbutton.click();
		
	}

	 /* Used to fetch path from path.properties file
	 * return : String value of path
	 */
	public static String getPath(String strPathName) {		
		testPathProp = new Properties();
	      try {
	      FileInputStream Master = new FileInputStream(path);
	      testPathProp.load(Master);
	      Master.close();
	          }catch (IOException e) {
	           System.out.println(e.getMessage());
	         }
	      return testPathProp.getProperty(strPathName);
	}
}
