package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login {

	public WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Email:']/following-sibling::input[@id='Email']")
	private WebElement emailFieldElement;

	@FindBy(xpath = "//label[text()='Password:']//following-sibling::input")
	private WebElement passFieldElement;

	@FindBy(xpath = "//input[@id='RememberMe']")
	private WebElement remmeberMElement;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	private WebElement loginButtonElement;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement getVlaidationMessag;

	public void setEmailId(String email) {
		emailFieldElement.clear();
		emailFieldElement.sendKeys(email);

	}

	public void setPassWord(String pass) {
		passFieldElement.clear();
		passFieldElement.sendKeys(pass);

	}

	public void checkRemmberMeOption() {
		remmeberMElement.click();
	}

	public void clickLoginButton() {
		loginButtonElement.click();
		
	}
}