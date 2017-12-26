package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Object_Repo.Home_Page;
import cucumber.api.PendingException;
import cucumber.api.java.After;
//import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.ScenarioImpl;
import cucumber.api.Scenario;
import static org.junit.Assert.assertEquals;
import Util.ExcelUtil;
import Library.KeyWordLibrary;
public class Login extends KeyWordLibrary {
	static WebDriver driver;
	@Before public void ad() {
		System.out.println("started test");
	}
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jitendermaan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://wwwsysc.sce.com");
	   
	    
	    
	}


	@Then("^User Navigated to Overview Page$")
	public void user_Navigated_to_Profile_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String a=driver.findElement(Home_Page.WebUserLinkAccount).getText();
		System.out.println(a);
		System.out.println(driver.getTitle());
		assertEquals("Overview | My Account | Home - SCE",driver.getTitle());
		
	}
	@Then("^User Navigated to My Account Page$")
	public void user_Navigated_to_My_Account_Page() throws Throwable {
//		System.out.println(driver.getTitle());
//		String a=driver.findElement(Home_Page.Title_Logout).getText();
//		assertEquals("Billing & Payment",a);
		assertEquals("Billing & Payment | Billing & Payments | My Account | Home - SCE",driver.getTitle());
//	    throw new PendingException();
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_enters_and_for(String arg1, String arg2, String arg3) throws Throwable {
		String username=ExcelUtil.Get(arg3, arg1);
		String password=ExcelUtil.Get(arg3, arg2);
		driver.findElement(Home_Page.UserName).sendKeys(username);
		driver.findElement(Home_Page.password).sendKeys(password);
		driver.findElement(Home_Page.login).click();		
	}
	@Then("^Error message displayed$")
	public void error_message_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^User Navigated to Third Party Page$")
	public void user_Navigated_to_Third_Party_Page() throws Throwable {
	    throw new PendingException();
	}
	
	@After
	public void logout(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); 
		
//		driver.findElement(Home_Page.Lbl_UserName).click();
//		driver.findElement(Home_Page.btn_Logout).click();	
//		String a=driver.findElement(Home_Page.Title_Logout).getText();
//		assertEquals("You have successfully logged out.",a);
//		driver.quit();
	}
}