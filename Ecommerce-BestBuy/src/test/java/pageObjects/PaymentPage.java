package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

	private WebDriver driver;
	JavascriptExecutor executor;
	Actions at;
	WebDriverWait wait;
	Select sel;
	
	//Constructor used to initialize the driver & all page objects of Payments Page
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Reusable element in Multiple methods
	@FindBy(xpath = "//a[normalize-space()='Go to Cart']")
	WebElement goToCartButton;
	// Reusable element in Multiple methods
	@FindBy(xpath = "//span[@class='added-to-cart']")
	WebElement successMsgElement;

	//Locating WebElements on the Payments Page
	@FindBy(css = ".btn.btn-lg.btn-block.btn-primary")
	WebElement btn_CheckOut;
	@FindBy(css = "button[class='c-button c-button-secondary c-button-lg cia-guest-content__continue guest']")
	WebElement btn_ContAsGuest;
	@FindBy(css = "input[name='emailAddress']")
	WebElement email_PaymentPage;
	@FindBy(css = "input[name='phone']")
	WebElement phone_PaymentPage;
	@FindBy(css = ".btn.btn-lg.btn-block.btn-secondary")
	WebElement btn_contPaymentInfo;
//	@FindBy(css = "//button[normalize-space()='Skip for now']")
//	WebElement btn_SkipForNow;
	
	@FindBy(id = "number")
	WebElement cardNumber;
	@FindBy(id = "expMonth")
	WebElement cardExpMonth;
	@FindBy(id = "expYear")
	WebElement cardExpYear;
	@FindBy(id = "cvv")
	WebElement cardSecCode;
	@FindBy(id = "first-name")
	WebElement fnameBilling;
	@FindBy(id = "last-name")
	WebElement lnameBilling;
	@FindBy(id = "address-input")
	WebElement addrBilling;
	@FindBy(id = "city")
	WebElement cityBilling;
	@FindBy(id = "state")
	WebElement stateBilling;
	@FindBy(id = "postalCode")
	WebElement zipBilling;
	@FindBy(css = ".btn.btn-lg.btn-block.btn-primary")
	WebElement btn_placeYourOrder;
	
	@FindBy(className = "container")
	WebElement modalContainer;
//	@FindBy(css = "//button[normalize-space()='Keep Address as Entered']")
//	WebElement keepSameAddress;
	@FindBy(xpath = "//span[contains(text(),'Unfortunately, we were unable to process')]")
	WebElement paymentMsgElement;

	//Performing action on WebElements to setup Contact info for payment 
	public void setContactInfoForPayment(String email, String contactNo) {
		btn_CheckOut.click();
		btn_ContAsGuest.click();
		email_PaymentPage.sendKeys(email);
		phone_PaymentPage.sendKeys(contactNo);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", btn_contPaymentInfo);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		btn_contPaymentInfo.click();
	}
	
	//Performing action on WebElements to enter card details 
	public void setPaymentDetails(String ccNo, String ccExMonth, String ccExYear, String ccSecCode) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(cardNumber));
		cardNumber.sendKeys(ccNo);
		sel = new Select(cardExpMonth);
		sel.selectByValue(ccExMonth);
		sel = new Select(cardExpYear);
		sel.selectByValue(ccExYear);
		cardSecCode.sendKeys(ccSecCode);
	}
	
	//Performing action on WebElements to setup Billing Details 
	public void setBillingDetails(String fname, String lname, String addr, String city, String state, String zip) {
		fnameBilling.sendKeys(fname);
		lnameBilling.sendKeys(lname);
		addrBilling.sendKeys(addr);
		cityBilling.sendKeys(city);
		sel = new Select(stateBilling);
		sel.selectByValue(state);
		zipBilling.sendKeys(zip);
	}
	
	//Performing action on WebElements to place order 
	public String checkOut() {
		btn_placeYourOrder.click();
		modalContainer.findElement(By.cssSelector("//button[normalize-space()='Keep Address as Entered']")).click();
	//	keepSameAddress.click();
		return paymentMsgElement.getText();
	}

}
