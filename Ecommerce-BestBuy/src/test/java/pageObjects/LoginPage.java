package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//Constructor used to initialize the driver & all page objects of Login Page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating WebElements on the Login Page
	@FindBy(id = "fld-e")
	WebElement txt_loginemail;

	@FindBy(id = "fld-p1")
	WebElement txt_loginPassword;

	@FindBy(css = "button[type='submit']")
	WebElement btn_signIn;

//	@FindBy(css = ".c-button-link.cia-cancel")
//	WebElement link_skipForNow;

	//Performing action on WebElement to fill User details for Login
	public void setLoginEmail(String email) {
		txt_loginemail.sendKeys(email);
	}

	public void setLoginPassword(String passWord) {
		txt_loginPassword.sendKeys(passWord);
	}
	
	//Performing action of clicking SignIn button for login
	public void clickLogin() {
		btn_signIn.click();
		// link_skipForNow.click();
	}
}
