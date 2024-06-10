package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsPage {

	WebDriver driver;
	
	//Constructor used to initialize the driver & all page objects of MyAccounts Page
	public MyAccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating WebElements on the My Accounts Page
	@FindBy(xpath = "(//button[@id='account-menu-account-button'])[1]")
	WebElement btn_signedUserAcc;

	@FindBy(css = "#account-menu-account-button")
	WebElement btn_loggedUserAcc;

	@FindBy(css = "div[class='bby-member-container']>a")
	WebElement link_memberBenefits;

	@FindBy(xpath = "//a[normalize-space()='Return to previous page']")
	WebElement link_previousPage;

	@FindBy(id = "logout-button-bby")
	WebElement btn_signout;
	
	//Performing action of accessing My Accounts after logged in
	public void clickMyAccountOption() {
		btn_loggedUserAcc.click();
	}
	
	//Performing actions on WebElements to check for successful SignUp
	public String getSuccessSignupMsg() {
		try {
			return (btn_signedUserAcc.getText());
		} catch (Exception e) {
			return ("An account with this email already exists. Please sign in or use a different email address.");
		}
	}
	
	//Performing actions on WebElements to check for successful Login
	public boolean isSuccessLoginExists() {
		try {
			return (link_memberBenefits.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	//Performing action of returning to previous page
	public void returnToPreviousPage() {
		link_previousPage.click();
	}
	
	//Performing action of Logout
	public void clickSignout() {
		btn_signout.click();
	}

}
