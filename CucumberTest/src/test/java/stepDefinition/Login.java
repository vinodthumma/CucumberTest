package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
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
//import cucumber.api.StepDefinitionReporter;
import Library.KeyWordLibrary;
import Library.DriverFactory;
public class Login extends KeyWordLibrary {
	static WebDriver driver;
	private Scenario myScenario;
	private String browser;
//	private StepDefinitionReporter reporter;
	@Before public void embedScreenshotStep(Scenario scenario)  {
		myScenario = scenario;
		browser=System.getProperty("BROWSER_NAME");
		driver=DriverFactory.createNewDriverInstance(browser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://wwwsysc.sce.com");
	    myScenario.write("Current Page URL is " + driver.getCurrentUrl()+"\n User is on SCE HOME PAGE");
	    Take_A_Screenshot( driver, myScenario); 
	}


	@Then("^User Navigated to Overview Page$")
	public void user_Navigated_to_Profile_Page() throws Throwable {
		assertEquals("Overview | My Account | Home - SCE",driver.getTitle());
		myScenario.write("User is on Overview page");
		Take_A_Screenshot( driver, myScenario);
	}
	@Then("^User Navigated to My Account Page$")
	public void user_Navigated_to_My_Account_Page() throws Throwable {
	assertEquals("Billing & Payment | Billing & Payments | My Account | Home - SCE",driver.getTitle());
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
	    throw new PendingException();
	}

	@Then("^User Navigated to Third Party Page$")
	public void user_Navigated_to_Third_Party_Page() throws Throwable {
	    throw new PendingException();
	}
	
	@When("^User clicks on registration button$")
	public void user_clicks_on_registration_button() throws Throwable {
		findElement(driver,Registration_Objects.Btn_Registration).click();
		
		
	}

	@Then("^User Navigates to Registration page$")
	public void user_Navigates_to_Registration_page() throws Throwable {
		 myScenario.write("Current Page URL is " + driver.getCurrentUrl());
		    myScenario.write("User is on SCE Registration page");
		    Take_A_Screenshot( driver, myScenario);
	}

	@When("^User Enters First Name, Last Name$")
	public void user_Enters_First_Name_Last_Name() throws Throwable {
		findElement(driver,Registration_Objects.Txt_FirstName).sendKeys("FName");
		findElement(driver,Registration_Objects.Txt_LastName).sendKeys("LName");
		Take_A_Screenshot( driver, myScenario);
		
	}

	@When("^user enters EMail address and Password$")
	public void user_enters_EMail_address_and_Password() throws Throwable {
		findElement(driver,Registration_Objects.Txt_emailAddress).sendKeys("email@gmail.com");
		findElement(driver,Registration_Objects.Txt_RegisterPassword).sendKeys("Edison123");
		findElement(driver,Registration_Objects.Txt_ConfirmPassword).sendKeys("Edison123");
		Take_A_Screenshot( driver, myScenario);
	}

	@When("^user click on Next$")
	public void user_click_on_Next() throws Throwable {
		findElement(driver,Registration_Objects.Btn_Registration_Next_1).click();
		Take_A_Screenshot( driver, myScenario);
	}

	@Then("^User will be navigated to Identify your sce account page$")
	public void user_will_be_navigated_to_Identify_your_sce_account_page() throws Throwable {
	    myScenario.write("Current Page URL is " + driver.getCurrentUrl());
	    myScenario.write("User is on Identify your sce account page");
	    Take_A_Screenshot( driver, myScenario);
	}
	
	@After
	public void logout(Scenario scenario) {
		DriverFactory.destroyDriver();
//		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	      scenario.embed(screenshot, "image/png"); 
		
//		driver.findElement(Home_Page.Lbl_UserName).click();
//		driver.findElement(Home_Page.btn_Logout).click();	
//		String a=driver.findElement(Home_Page.Title_Logout).getText();
//		assertEquals("You have successfully logged out.",a);
//		driver.quit();
	}
}
