package Library;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class KeyWordLibrary {
	Properties properties;
static Properties Pathproperties;
	
public static final String path="src\\test\\resources\\path.properties";

	/*function:getPath(String strPathName)
	 * Used to fetch path from path.properties file
	 * return : String value of path
	 */
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
	
	
	
public void WebElementClick(WebDriver driver,By locator){
		
		
		WebElement Element=(new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		Element= (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(locator));
		Element.click();
	}




 public By getLocator(String ElementName) throws Exception {
     //Read value using the logical name as Key
     String locator = properties.getProperty(ElementName);
     //Split the value which contains locator type and locator value
     String locatorType = locator.split(":")[0];
     String locatorValue = locator.split(":")[1];
     //Return a instance of By class based on type of locator
       if(locatorType.toLowerCase().equals("id"))
             return By.id(locatorValue);
       else if(locatorType.toLowerCase().equals("name"))
             return By.name(locatorValue);
       else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
             return By.className(locatorValue);
       else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
             return By.className(locatorValue);
       else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
             return By.linkText(locatorValue);
       else if(locatorType.toLowerCase().equals("partiallinktext"))
             return By.partialLinkText(locatorValue);
       else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
             return By.cssSelector(locatorValue);
       else if(locatorType.toLowerCase().equals("xpath"))
             return By.xpath(locatorValue);
       else
               throw new Exception("Locator type '" + locatorType + "' not defined!!");
     }


 public void Take_A_Screenshot(WebDriver driver,Scenario myScenario) throws Throwable {

     try {
         
         byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         myScenario.embed(screenshot, "image/png");  // Stick it in the report
     } catch (WebDriverException somePlatformsDontSupportScreenshots) {

         System.out.println((somePlatformsDontSupportScreenshots.getMessage().toString()));
     } catch (ClassCastException cce) {
         cce.printStackTrace();
     }
 }

 public WebElement getWebElement(final WebDriver driver,final By Locator) {
//	 WebElement ele=driver.findElement(Locator);
	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                            
			 .withTimeout(20, TimeUnit.SECONDS)          
			 .pollingEvery(5, TimeUnit.SECONDS)          
			 .ignoring(NoSuchElementException.class);    

			   WebElement ele= wait.until(new Function<WebDriver, WebElement>() {       
			 public WebElement apply(WebDriver driver) { 
			 return driver.findElement(Locator);     
			  }  
			 });
			return ele;
 }
 public static WebElement findElement(final WebDriver driver, final By locator) {
	 System.out.println(locator);
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(20, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    return wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });
	}

}
