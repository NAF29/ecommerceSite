package stepDefin;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageObject.Login;
import readConfig.ReadConfig;

public class LoginSteps extends BaseClass{


	@Before
	public void setup() throws IOException {
		readConfig = new ReadConfig();
		log=LogManager.getLogger("stepDefin");
		
		String browser = readConfig.getBrowser();
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(opt);
			log.info("Setup executed");
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		default:
			driver = null;
			break;
		}

	}

	@Given("user opens the browser")
	public void user_opens_the_browser() throws IOException {

		driver.get(readConfig.getURl());

		login = new Login(driver);
		log.info("browser open");
	}

	@When("user Enters url")
	public void user_enters_url() {

	}

	@When("I enter valid username")
	public void i_enter_valid_username_and_password() {
		login.setEmailId(readConfig.getEmail());
		

	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		login.setPassWord(readConfig.getPassword());

	}

	@Given("I click on the login button")
	public void i_click_on_the_login_button() {
		login.clickLoginButton();
		String titleString = driver.getTitle();
		System.out.println(titleString);

	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		log.warn("test Passed: login page");
	}

	@When("I enter an invalid username")
	public void i_enter_an_invalid_username() {
		login.setEmailId(readConfig.getEmail());
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		login.setPassWord(readConfig.getPassword());
	}

	@Then("I should see an error message indicating invalid credentials")
	public void i_should_see_an_error_message_indicating_invalid_credentials() {
		driver.getTitle();

	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		login.setEmailId(readConfig.getEmail());
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		login.setPassWord(readConfig.getPassword());
	}

	@When("I leave the username and password fields empty")
	public void i_leave_the_username_and_password_fields_empty() {
		login.setEmailId(readConfig.getEmail());
		login.setPassWord(readConfig.getPassword());
	}

	@Then("I should see an error message indicating required fields")
	public void i_should_see_an_error_message_indicating_required_fields() {

	}

	@When("I click on the forgot password link")
	public void i_click_on_the_forgot_password_link() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("I have previously logged in with {string} option checked")
	public void i_have_previously_logged_in_with_option_checked(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I revisit the login page")
	public void i_revisit_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see my username pre-populated")
	public void i_should_see_my_username_pre_populated() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should be able to login without entering credentials again")
	public void i_should_be_able_to_login_without_entering_credentials_again() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@After
	public void tearDown(Scenario sc) {
		if (sc.isFailed() == true) {
			try {
				File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(screenShotFile, new File("/Users/nafis/eclipse/DemoSites/screenshot/heel.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		driver.close();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}

}
