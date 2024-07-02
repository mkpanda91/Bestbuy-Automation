package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrepaymentPage {

	private WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;

	//Constructor used to initialize the driver & all page objects of Prepayment Page
	public PrepaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}
	
	// Locating WebElements on the Prepayment Page
	@FindBy(xpath = "//iframe[@class='card_number_iframe']")
	WebElement iframe_cardNumber;
	@FindBy(xpath = "//iframe[@class='name_on_card_iframe']")
	WebElement iframe_cardName;
	@FindBy(xpath = "//iframe[@class='card_exp_month_iframe']")
	WebElement iframe_cardExpMonth;
	@FindBy(xpath = "//iframe[@class='card_exp_year_iframe']")
	WebElement iframe_cardExpYear;
	@FindBy(xpath = "//iframe[@class='security_code_iframe']")
	WebElement iframe_cardSecCode;

	@FindBy(xpath = "//div[@class='at_prepayment_modal']")
	WebElement prePaymentModal;
	@FindBy(css = "div[id='at_prepayment_modal'] div[id='at_prepayment_close_icon']>img")
	WebElement close_prePaymentModal;
	@FindBy(css = "div.css-1dbjc4n form#payment_form")
	WebElement div_paymentForm;
	@FindBy(id = "card_number")
	WebElement txt_cardNumber;
	@FindBy(id = "name_on_card")
	WebElement txt_cardName;
	@FindBy(id = "card_exp_month")
	WebElement txt_cardExpMonth;
	@FindBy(id = "card_exp_year")
	WebElement txt_cardExpYear;
	@FindBy(id = "security_code")
	WebElement txt_cardSecCode;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-1adg3ll r-u8s1d']//div[@class='css-76zvg2 r-homxoj r-poiln3']")
	WebElement tandc;
	@FindBy(xpath = "//div[contains(@data-testid,'common-proceed-to-pay')]")
	WebElement btn_Continue;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79 r-15zivkp']")
	WebElement ele_paymentFail;

	
	//Performing actions on WebElements of the Prepayment Page
	public void setCardNumber(String cNumber) {
		try {
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoViewIfNeeded();", div_paymentForm);
			driver.switchTo().frame(iframe_cardNumber);
			txt_cardNumber.sendKeys(cNumber);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			setCardNumber(cNumber);
		}
	}

	public void setCardName(String cName) {
		try {
			driver.switchTo().frame(iframe_cardName);
			txt_cardName.sendKeys(cName);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			setCardName(cName);
		}
	}

	public void setCardExpiryMonth(String cExpMon) {
		try {
			driver.switchTo().frame(iframe_cardExpMonth);
			txt_cardExpMonth.sendKeys(cExpMon);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			setCardExpiryMonth(cExpMon);
		}
	}

	public void setCardExpiryYear(String cExpYr) {
		try {
			driver.switchTo().frame(iframe_cardExpYear);
			txt_cardExpYear.sendKeys(cExpYr);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			setCardExpiryYear(cExpYr);
		}
	}

	public void setCardSecurity(String cSecCode) {
		try {
			driver.switchTo().frame(iframe_cardSecCode);
			txt_cardSecCode.sendKeys(cSecCode);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			setCardSecurity(cSecCode);
		}
	}

	public String clickContinue() throws InterruptedException {
		try {
			js.executeScript("arguments[0].scrollIntoView();", tandc);
			btn_Continue.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			close_prePaymentModal.click();
			clickContinue();
		}
		wait.until(ExpectedConditions.visibilityOf(ele_paymentFail));
		return ele_paymentFail.getText();
	}
}
