package Library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StartUp {
	
	public StartUp() {
		// TODO Auto-generated constructor stub
	}
/*Get Driver:this function will get the driver as per provided in testng xml file
 * get data from device setup excel sheet
 * create browser as per the setup excel file
 * 
 * */
	
	public static RemoteWebDriver getDriver(String browserType){
              DesiredCapabilities dr=null;
              if(browserType.equals("firefox")){
              dr=DesiredCapabilities.firefox();
//              dr.setBrowserName("firefox");
              dr.setPlatform(Platform.WINDOWS);
              dr.setCapability("port", 5557);
             
              }else if (browserType.equals("IE")){
                       dr=DesiredCapabilities.internetExplorer();
//                       dr.setBrowserName("iexplore");
                       dr.setPlatform(Platform.WINDOWS);
                       dr.setCapability("port", 5556);
                   
              }else if(browserType.equals("chrome")){
                  dr=DesiredCapabilities.chrome();
//                dr.setBrowserName("iexplore");
                dr.setPlatform(Platform.WINDOWS);
                dr.setCapability("port", 5558);
            	  
              }
              
              RemoteWebDriver driver;
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
				return driver;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		  	
		
		
	}

}
