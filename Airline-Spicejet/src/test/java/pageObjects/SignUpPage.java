package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	private WebDriver driver;
	Select sel;
	JavascriptExecutor js;
	WebDriverWait wait;

	// Constructor used to initialize the driver & all page objects of SignUp Page
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

	// Locating WebElements on the SignUp Page
	@FindBy(css = "a[href='https://spiceclub.spicejet.com/signup']")
	WebElement link_Signup;
	@FindBy(xpath = "(//select[contains(@class,'form-control form-select')])[1]")
	WebElement drdown_Title;
	@FindBy(id = "first_name")
	WebElement txt_Fname;
	@FindBy(id = "last_name")
	WebElement txt_Lname;
	@FindBy(xpath = "(//select[@class='form-control form-select'])[1]")
	WebElement drdown_Country;
	@FindBy(id = "dobDate")
	WebElement field_Dob;
	@FindBy(css = "select.react-datepicker__year-select")
	WebElement field_Dob_Year;
	@FindBy(css = "select.react-datepicker__month-select")
	WebElement field_Dob_Month;
	@FindBy(xpath = "(//div[@class='react-datepicker__week'])[3]//following-sibling::div[2]")
	WebElement field_Dob_Date;
	@FindBy(css = "div[class=' flag-dropdown']")
	WebElement drdown_flag;
	@FindBy(xpath = "//div[@class=' flag-dropdown open']//ul[@role='listbox']//descendant::li[85]")
	WebElement drdown_selectFlag;
	@FindBy(xpath = "//div[@class='special-label']//following-sibling::input")
	WebElement txt_mobNumber;
	@FindBy(id = "email_id")
	WebElement field_email;
	@FindBy(id = "new-password")
	WebElement field_password;
	@FindBy(id = "c-password")
	WebElement field_cpassword;
	@FindBy(css = "#defaultCheck1")
	WebElement chk_Box;
	@FindBy(css = "button[type='button']")
	WebElement btn_Submit;

	@FindBy(css = "label.modal-red-title.mb-2")
	WebElement signUpVerifyElement;

	// Performing actions on WebElements of the SignUp Page
	public void setTitle() {
		sel = new Select(drdown_Title);
		sel.selectByIndex(1);
	}

	public void setFirstName(String first) {
		txt_Fname.sendKeys(first);
	}

	public void setLastName(String last) {
		txt_Fname.sendKeys(Keys.TAB);
		txt_Lname.sendKeys(last);
	}

	public void setCountry() {
		js.executeScript("arguments[0].scrollIntoView();", drdown_Country);
		sel = new Select(drdown_Country);
		sel.selectByIndex(101);
	}

	public void setDoB(String date) {
		js.executeScript("arguments[0].scrollIntoView();", field_Dob);
		wait.until(ExpectedConditions.elementToBeClickable(field_Dob));
		field_Dob.click();
		sel = new Select(field_Dob_Year);
		sel.selectByValue("1990");
		sel = new Select(field_Dob_Month);
		sel.selectByValue("1");
		field_Dob_Date.click();
	}

	public void setMobileNumber(String mobNum) {
		js.executeScript("arguments[0].scrollIntoView();", drdown_flag);
		drdown_flag.click();
		js.executeScript("arguments[0].click();", drdown_selectFlag);
		wait.until(ExpectedConditions.elementToBeClickable(txt_mobNumber));
		txt_mobNumber.sendKeys(mobNum);
		txt_mobNumber.sendKeys(Keys.TAB);
		txt_mobNumber.sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public void setEmail(String emailAddr) {
		wait.until(ExpectedConditions.elementToBeClickable(field_email));
		field_email.sendKeys(emailAddr);
	}

	public void setPassword(String pword) {
		wait.until(ExpectedConditions.elementToBeClickable(field_password));
		field_password.sendKeys(pword);
		field_password.sendKeys(Keys.TAB);
	}

	public void setConfirmPassword(String cpword) {
		wait.until(ExpectedConditions.elementToBeClickable(field_cpassword));
		field_cpassword.sendKeys(cpword);
	}

	public void submitSignup() {
		js.executeScript("arguments[0].scrollIntoView();", chk_Box);
		js.executeScript("arguments[0].click();", chk_Box);
		btn_Submit.click();
	}

	public String getPostSignUpVerification() {
		try {
			wait.until(ExpectedConditions.visibilityOf(signUpVerifyElement));
		} catch (Exception e) {
			System.out.println("OTP popup is not displayed");
			return null ;
		}
		return (signUpVerifyElement.getText());
	}
}
