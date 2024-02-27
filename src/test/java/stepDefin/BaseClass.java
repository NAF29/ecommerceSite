package stepDefin;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.Login;
import readConfig.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	public Login login;
	public ReadConfig readConfig;
	public static Logger log;
}
