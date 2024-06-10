package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountrySelectionPage {

	public WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
	//Constructor used to initialize the driver & all page objects of Country selection Page
	public CountrySelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(this.driver);
	}

	//Locating WebElements for Country selecting as CANADA or USA
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[1]")
	WebElement link_countryIsCanada;
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement link_countryIsUS;

	//Performing actions to select Country as USA or Canada
	public void chooseCountryAsCanada() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(link_countryIsCanada));
		action.moveToElement(link_countryIsCanada).click().build().perform();
	}
	
	public void chooseCountryAsUS() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(link_countryIsUS));
		action.moveToElement(link_countryIsUS).click().build().perform();
	}
}
