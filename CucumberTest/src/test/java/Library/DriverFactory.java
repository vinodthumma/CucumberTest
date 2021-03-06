package Library;

//import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Library.KeyWordLibrary;
public class DriverFactory extends KeyWordLibrary{
	protected static WebDriver driver;
//	static String browser;

//    public DriverFactory(String strBrowser) {
//    	browser=strBrowser;
//        initialize();
//    }

//    public void initialize() {
//        if (driver == null)
//    	System.out.println(browser);
//            createNewDriverInstance();
//    }

    public static WebDriver createNewDriverInstance(String browser) {
    	System.out.println(browser);
    	
    	if (browser.equalsIgnoreCase("chrome")){
    		System.out.println("inside chrome");
    		String strBrowserPath=getPath("ChromeDriver");
//    		System.out.println(strBrowserPath);
    		System.setProperty("webdriver.chrome.driver",strBrowserPath);
    		driver = new ChromeDriver();
    	}
    	else if(browser.equalsIgnoreCase("firefox")) {
    		String strBrowserPath=getPath("GeckoDriver");
    		System.setProperty("webdriver.gecko.driver",strBrowserPath);
    		driver = new FirefoxDriver();    		
    	}
    	else if(browser.equalsIgnoreCase("phantomjs")) {
//    		Capabilities caps = new DesiredCapabilities();
//    		((DesiredCapabilities) caps).setJavascriptEnabled(true);
//    		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
//    		((DesiredCapabilities) caps).setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"path of executable");
//    		driver = new PhantomJSDriver(caps);

    	}
    	else if(browser.equalsIgnoreCase("IE")) {
    		String strBrowserPath=getPath("IEDriver");
    		System.setProperty("webdriver.ie.driver",strBrowserPath);
    		driver = new InternetExplorerDriver();
    	}
    	else {
    		String strBrowserPath=getPath("ChromeDriver");
    		System.setProperty("webdriver.chrome.driver",strBrowserPath);
    		driver = new ChromeDriver();
    	}
//        driver = new FirefoxDriver();
    	return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
