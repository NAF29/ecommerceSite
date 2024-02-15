package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/nafis/eclipse/DemoSites/featureFile/Login.feature",
		glue = "stepDefin",
		dryRun = false,
		tags = "@regression",
		plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
		
		
		)
public class TestRuuner extends AbstractTestNGCucumberTests{

}
