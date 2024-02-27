package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/nafis/eclipse/DemoSites/featureFile/Login.feature",
		glue = "stepDefin",
		dryRun = false,
		tags = "@Sanity",
		//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		
		)
public class TestRuuner extends AbstractTestNGCucumberTests {

}
