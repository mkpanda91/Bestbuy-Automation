package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	JavascriptExecutor executor;
	Actions at;
	WebDriverWait wait;
	Select sel;

	// Constructor used to initialize the driver & all page objects of Home Page
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating WebElements on the Home Page
	@FindBy(xpath = "//a[@title='BestBuy.com']")
	WebElement link_logoTitle;

	@FindBy(css = "div.bottom-nav-left-wrapper>ul>li>a")
	List<WebElement> leftNav_Elements;

	@FindBy(css = ".flex.justify-content-start>a")
	List<WebElement> footerElements;

	@FindBy(css = "span.v-p-right-xxs.line-clamp")
	WebElement link_Account;

	@FindBy(css = "a.c-button.c-button-outline.c-button-sm.create-account-btn")
	WebElement btn_createAccount;

	@FindBy(css = "a.c-button.c-button-secondary.c-button-sm.sign-in-btn")
	WebElement btn_SignIn;

	@FindBy(css = "button[aria-label='Menu']")
	WebElement btn_Menu;

	@FindBy(id = "gh-search-input")
	WebElement searchBar;
	@FindBy(className = "header-search-button")
	WebElement searchButton;

	@FindBy(css = ".hamburger-menu-flyout-list")
	WebElement menuFlyoutElement;

	@FindBy(css = "li:nth-child(10) button:nth-child(1)")
	WebElement deptAudio;
	@FindBy(xpath = "//button[normalize-space()='Headphones']")
	WebElement audioHeadphones;
	@FindBy(linkText = "Wireless Headphones")
	WebElement link_Wireless;

	@FindBy(xpath = "//button[normalize-space()='Brands']")
	WebElement link_Brands;
	@FindBy(xpath = "//a[normalize-space()='Samsung']")
	WebElement link_Samsung;

	// Performing actions on the elements located on the Home Page
	public String getSiteUrl() {
		String siteUrl = link_logoTitle.getAttribute("href");
		return siteUrl;
	}

	public List<WebElement> getLeftNavigationMenuElements() {
		return leftNav_Elements;
	}

	public List<WebElement> getFooterElements() {
		return footerElements;
	}

	// Performing action of click the My Account link
	public void clickAccountLink() {
		link_Account.click();
	}

	// Performing action of click the Create Account button for SignUp
	public void clickCreateAccountButton() {
		btn_createAccount.click();
	}

	// Performing action of click the SignIn button for Login
	public void clickSignInButton() {
		btn_SignIn.click();
	}

	// Performing action of click the Menu button
	public void clickMenuOption() {
		btn_Menu.click();
	}

	// Performing action of entering search keyword and clicking Search
	public void keywordSearchAndClick(String searchKey) {
		searchBar.sendKeys(searchKey);
		searchButton.click();
	}

	// Performing action of searching products by specific Department
	public void goToDeptSearchResults() {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("document.querySelector('.hamburger-menu-flyout-list').scrollBy(0,200)");

		deptAudio.click();
		audioHeadphones.click();
		link_Wireless.click();
	}

	// Performing action of searching products by a specific Brand
	public void goToBrandSearchResults() {
		link_Brands.click();
		link_Samsung.click();
	}

	/*
	 * Below elements and corresponding actions are with respect to Country
	 * selection as "Canada"
	 */
	@FindBy(xpath = "//a[@aria-label='Best Buy']//*[name()='svg']")
	WebElement ca_logoTitle;

	@FindBy(xpath = "(//li[@class='style-module_rootMenuItem__RK6kc']/child::button)[1]")
	WebElement ca_link_shop;
	@FindBy(xpath = "(//div[@data-automation='menu-main-l1']//child::a[3])[1]")
	WebElement ca_link_brands;
	@FindBy(css = "a[title='L M N O']")
	WebElement ca_link_brandsByAlpha;
	@FindBy(css = "a[title='LG']")
	WebElement ca_link_brandAsLG;

	public String ca_getSiteUrl() {
		return driver.getCurrentUrl();
	}

	public void ca_goToBrandSearchResults() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ca_link_shop));
		ca_link_shop.click();
		ca_link_brands.click();
		ca_link_brandsByAlpha.click();
		ca_link_brandAsLG.click();
	}
}
