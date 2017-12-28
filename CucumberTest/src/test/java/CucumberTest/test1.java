package CucumberTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test1 {
	public static final String path="src\\test\\resources\\path.properties";
	static Properties Pathproperties;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPath("GeckoDriver"));
//public void start() {
//	WebDriver driver=new FirefoxDriver();
//	driver.get("https://wwww.google.com");
}
	public static String getPath(String strPathName) {		
		Pathproperties = new Properties();
		System.out.println("Inside Get path");
		System.out.println(strPathName);
	      try {
	      FileInputStream Master = new FileInputStream(path);
	      Pathproperties.load(Master);
	      Master.close();
	          }catch (IOException e) {
	           System.out.println(e.getMessage());
	         }
	      System.out.println(Pathproperties.getProperty(strPathName));
	      return Pathproperties.getProperty(strPathName);
	}
}
