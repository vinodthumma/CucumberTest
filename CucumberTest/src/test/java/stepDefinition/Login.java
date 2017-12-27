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
import Object_Repo.Registration_Objects;
import cucumber.api.PendingException;
import cucumber.api.java.After;
//import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;
import static org.junit.Assert.assertEquals;
import Util.ExcelUtil;
import cucumber.api.StepDefinitionReporter;
import Library.KeyWordLibrary;

public class Login extends KeyWordLibrary {
	static WebDriver driver;
	private Scenario myScenario;
	private StepDefinitionReporter reporter;
	@Before public void embedScreenshotStep(Scenario scenario)  {
		System.out.println("started test");
		myScenario = scenario;
	}
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://wwwsysc.sce.com");
	    myScenario.write("Current Page URL is " + driver.getCurrentUrl());
	    myScenario.write("User is on SCE HOME PAGE");
	    Take_A_Screenshot( driver, myScenario);
	    
	}


	@Then("^User Navigated to Overview Page$")
	public void user_Navigated_to_Profile_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String a=driver.findElement(Home_Page.WebUserLinkAccount).getText();
		System.out.println(a);
		System.out.println(driver.getTitle());
		assertEquals("Overview | My Account | Home - SCE",driver.getTitle());
		myScenario.write("User is on Overview page");
		Take_A_Screenshot( driver, myScenario);
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
	public void user_enters_and_for(String username, String password, String TestCaseID) throws Throwable {

		findElement(driver,Home_Page.UserName).sendKeys(ExcelUtil.Get(TestCaseID, username));
//		driver.findElement(Home_Page.UserName).sendKeys(ExcelUtil.Get(TestCaseID, username));
		driver.findElement(Home_Page.password).sendKeys(ExcelUtil.Get(TestCaseID, password));
		myScenario.write("User entered username and password");
		Take_A_Screenshot( driver, myScenario);
		
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
	
	@When("^User clicks on registration button$")
	public void user_clicks_on_registration_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		findElement(driver,Registration_Objects.Btn_Registration).click();
		
		
	}

	@Then("^User Navigates to Registration page$")
	public void user_Navigates_to_Registration_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		 myScenario.write("Current Page URL is " + driver.getCurrentUrl());
		    myScenario.write("User is on SCE Registration page");
		    Take_A_Screenshot( driver, myScenario);
	}

	@When("^User Enters First Name, Last Name$")
	public void user_Enters_First_Name_Last_Name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		findElement(driver,Registration_Objects.Txt_FirstName).sendKeys("FName");
		findElement(driver,Registration_Objects.Txt_LastName).sendKeys("LName");
		Take_A_Screenshot( driver, myScenario);
		
	}

	@When("^user enters EMail address and Password$")
	public void user_enters_EMail_address_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		findElement(driver,Registration_Objects.Txt_emailAddress).sendKeys("email@gmail.com");
		findElement(driver,Registration_Objects.Txt_RegisterPassword).sendKeys("Edison123");
		findElement(driver,Registration_Objects.Txt_ConfirmPassword).sendKeys("Edison123");
		Take_A_Screenshot( driver, myScenario);
	}

	@When("^user click on Next$")
	public void user_click_on_Next() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		findElement(driver,Registration_Objects.Btn_Registration_Next_1).click();
		Take_A_Screenshot( driver, myScenario);
//		reporter.stepDefinition("STEP FUNCTION");
	}

	@Then("^User will be navigated to Identify your sce account page$")
	public void user_will_be_navigated_to_Identify_your_sce_account_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	    myScenario.write("Current Page URL is " + driver.getCurrentUrl());
	    myScenario.write("User is on Identify your sce account page");
	    Take_A_Screenshot( driver, myScenario);
	}
	
	@After
	public void logout(Scenario scenario) {
//		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	      scenario.embed(screenshot, "image/png"); 
		
//		driver.findElement(Home_Page.Lbl_UserName).click();
//		driver.findElement(Home_Page.btn_Logout).click();	
//		String a=driver.findElement(Home_Page.Title_Logout).getText();
//		assertEquals("You have successfully logged out.",a);
//		driver.quit();
	}
}
