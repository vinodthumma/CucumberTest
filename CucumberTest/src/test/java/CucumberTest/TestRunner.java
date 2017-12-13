package CucumberTest;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/LogIn_Test.feature"
		,glue={"stepDefinition"}
		,plugin = {"pretty","html:target\\cucumber"}
		,tags= {"@tag4"}
		)
public class TestRunner{

}
