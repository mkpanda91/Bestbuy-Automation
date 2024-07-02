package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	WebDriverWait wait;

	//Constructor used to initialize the driver & all page objects of Login Page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locating WebElements on the Login Page
	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[3]")
	WebElement rbutton_Mobile;
	@FindBy(css = "input[type='number']")
	WebElement txt_LoginNumber;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']//child::div)[6]")
	WebElement rbutton_Email;
	@FindBy(css = "input[type='email']")
	WebElement txt_LoginEmail;
	@FindBy(css = "input[type='password']")
	WebElement txt_LoginPassword;
	@FindBy(css = "div[data-testid='login-cta']")
	WebElement btn_Login;
	@FindBy(xpath = "//div[normalize-space()='Hi Mahesh']")
	WebElement successLoginElement;

	
	//Performing actions on WebElements of the Login Page
	public void loginUsingMobile(String phoneNo, String passWord) {
		rbutton_Mobile.click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_LoginNumber));
		txt_LoginNumber.sendKeys(phoneNo);
		wait.until(ExpectedConditions.elementToBeClickable(txt_LoginPassword));
		txt_LoginPassword.sendKeys(passWord);
		btn_Login.click();
	}

	public void loginUsingEmail(String emailAddr, String passWord) {
		rbutton_Email.click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_LoginEmail));
		txt_LoginEmail.sendKeys(emailAddr);
		wait.until(ExpectedConditions.elementToBeClickable(txt_LoginPassword));
		txt_LoginPassword.sendKeys(passWord);
		btn_Login.click();
	}

	public String getSuccessLoginTxt() {
		wait.until(ExpectedConditions.visibilityOf(successLoginElement));
		return (successLoginElement.getText());
	}

	public Boolean isLoginButtonPresent() {
		return (btn_Login.isDisplayed());
	}

}
