package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	JavascriptExecutor executor;
	Actions at;
	WebDriverWait wait;
	Select sel;

	// Constructor used to initialize the driver & all page objects of Search Page
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating WebElements used for Search By Brand
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to Cart'])[2]")
	WebElement addByBrand;
	@FindBy(css = ".flex-link[href='/site/promo/samsung-watch-buds']")
	WebElement link_SamsungWB;

	// Locating WebElements used for Add/Go to Cart flow (Reusable Elements)
	@FindBy(xpath = "//button[normalize-space()='Add to Cart']")
	WebElement btn_addToCart;
	@FindBy(xpath = "//a[normalize-space()='Go to Cart']")
	WebElement goToCartButton;
	@FindBy(xpath = "//span[@class='added-to-cart']")
	WebElement successMsgElement;

	// Locating WebElements used for Filtering Search
	@FindBy(css = "span[class='item-count']")
	WebElement initItemCount;
	@FindBy(xpath = "(//ul[@class='facet-option-list'])[3]//child::li[1]//input")
	WebElement chk_selectFeature;

	// Locating WebElements used for Save Item test
	@FindBy(xpath = "(//div[@class='shop-sku-list-item'])[1]")
	WebElement eleToScrollForSave;
	@FindBy(xpath = "(//div[@class='sku-attribute-title'])[2]//span[@class='sku-value']")
	WebElement initial_sku;
	@FindBy(xpath = "(//button[@aria-label='Save'])[1]")
	WebElement saveFirst;
	@FindBy(css = "a[class='font-weight-medium']")
	WebElement link_mySavedItems;
	@FindBy(xpath = "(//div[@class='title']//child::a)[1]")
	WebElement link_eleSaved;
	@FindBy(xpath = "(//span[@class='product-data-value body-copy'])[2]")
	WebElement final_sku;

	// Performing action of searching and adding to cart
	public String addToCartBySearch() {
		at = new Actions(driver);
		executor = (JavascriptExecutor) driver;
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
		btn_addToCart.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(successMsgElement));
		String successMsgBySearch = (String) executor.executeScript("return arguments[0].innerHTML;",
				successMsgElement);
		return successMsgBySearch;
	}

	// Performing action of finding by Department and adding to cart
	public String addToCartByDept() {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0,300)");
		btn_addToCart.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(goToCartButton));
		String successMsgByDept = (String) executor.executeScript("return arguments[0].innerHTML;", successMsgElement);
		return successMsgByDept;

	}

	// Performing action of finding by Brand and adding to cart
	public String addToCartByBrand() {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0,100)");
		link_SamsungWB.click();
		executor.executeScript("window.scrollTo(0,400)");
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(addByBrand));
		addByBrand.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		String successMsgByBrand = (String) executor.executeScript("return arguments[0].innerHTML;", successMsgElement);
		return successMsgByBrand;
	}

	// Performing action of Going to cart (Reusable action)
	public void clickGoToCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(goToCartButton));
		goToCartButton.click();
	}

	// Performing action of filtering the search results by a criteria
	public String[] filterSearchResults() {
		String[] arr = new String[2];
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", initItemCount);
		arr[0] = initItemCount.getText();
		executor.executeScript("arguments[0].scrollIntoView(true);", chk_selectFeature);
		chk_selectFeature.click();
		executor.executeScript("arguments[0].scrollIntoView(true);", initItemCount);
		arr[1] = initItemCount.getText();
		return arr;
	}

	// Performing action of Saving an item and checking the same under "My Saved
	// Items"
	public String[] saveItem() {
		String[] arr = new String[2];
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", eleToScrollForSave);
		arr[0] = initial_sku.getText();
		saveFirst.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(link_mySavedItems));
		link_mySavedItems.click();
		executor.executeScript("window.scrollTo(0,250)", "");
		link_eleSaved.click();
		executor.executeScript("window.scrollTo(0,250)", "");
		arr[1] = final_sku.getText();
		return arr;
	}

	/*
	 * Below elements and corresponding actions are with respect to Country
	 * selection as "Canada"
	 */
	@FindBy(xpath = "(//div[@class='sliderTarget_2Q87g'])[2]")
	WebElement ca_link_prodOfLG;
	@FindBy(css = "h1[class='font-best-buy text-body-lg font-medium sm:text-title-sm']")
	WebElement ca_prodTitle;
	@FindBy(xpath = "(//form[@id='test']//button)[1]")
	WebElement ca_btn_addToCart;
	@FindBy(xpath = "//div[@class='styles-module_contentContainer__a4dEW']//p")
	WebElement ca_msg_addToCart;

	public String ca_addToCartByBrand() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", ca_link_prodOfLG);
		wait.until(ExpectedConditions.elementToBeClickable(ca_link_prodOfLG));
		ca_link_prodOfLG.click();
		wait.until(ExpectedConditions.visibilityOf(ca_prodTitle));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		executor.executeScript("arguments[0].scrollIntoView(true);",ca_btn_addToCart);
		wait.until(ExpectedConditions.elementToBeClickable(ca_btn_addToCart));
		ca_btn_addToCart.click();
		return ca_msg_addToCart.getText();
	}
}
