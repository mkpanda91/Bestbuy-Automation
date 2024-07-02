package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {

	private WebDriver driver;
	Select sel;

	// Constructor used to initialize the driver & all page objects of Dashboard
	// Page
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating WebElements on the Dashboard Page
	@FindBy(xpath = "//div[@class='d-none d-lg-block hello']")
	WebElement drdown_Toggle;
	@FindBy(xpath = "//span[normalize-space()='Log Out']")
	WebElement logout;

	// Performing actions on WebElements of the Dashboard Page
	public void userLogout() {
		drdown_Toggle.click();
		logout.click();
	}
}
