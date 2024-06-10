package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;
	
	//Constructor used to initialize the driver & all page objects of SignUp Page
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating WebElements on the SignUp Page
	@FindBy(id = "firstName")
	WebElement fName;

	@FindBy(id = "lastName")
	WebElement lName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "fld-p1")
	WebElement regPassword;

	@FindBy(id = "reenterPassword")
	WebElement regConfirmPassword;

	@FindBy(id = "phone")
	WebElement regMobNumber;

	@FindBy(css = "button[type='submit']")
	WebElement btn_createAnAcc;

	//Performing action on WebElement to set User details for SignUp
	public void setFirstName(String fname) {
		fName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lName.sendKeys(lname);
	}

	public void setEmail(String useremail) {
		email.sendKeys(useremail);
	}

	public void setPassword(String password) {
		regPassword.sendKeys(password);
	}

	public void setConfirmPassword(String confpassword) {
		regConfirmPassword.sendKeys(confpassword);
	}

	public void setMobileNumber(String mobnum) {
		regMobNumber.sendKeys(mobnum);
	}
	
	//Performing action of clicking Create Account to finish SignUp
	public void clickCreateAccount() {
		btn_createAnAcc.click();
	}
}
