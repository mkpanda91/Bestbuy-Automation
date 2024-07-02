package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PassengerInfoPage {

	private WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	// Constructor used to initialize the driver & all page objects of Passenger
	// Info Page
	public PassengerInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locating WebElements on the Passenger Info Page
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1ugchlj r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-1x93onp']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")
	WebElement field_Title;
	@FindBy(xpath = "//div[@class='css-1dbjc4n']//child::div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar']")
	List<WebElement> cont_ListOfTitles;
	@FindBy(xpath = "//input[contains(@data-testid,'first-inputbox-contact-details')]")
	WebElement cont_FirstName;
	@FindBy(xpath = "//input[contains(@data-testid,'last-inputbox-contact-details')]")
	WebElement cont_LastName;
	@FindBy(xpath = "//div[contains(@data-testid,'contact-number-country-selection')]")
	WebElement cont_ContNumSelect;
	@FindBy(xpath = "//input[contains(@data-testid,'contact-number-input-box')]")
	WebElement cont_Number;
	@FindBy(xpath = "//input[contains(@data-testid,'emailAddress-inputbox-contact-details')]")
	WebElement cont_Email;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-tmtnm0 r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-13qz1uu']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")
	WebElement cont_Country;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1dqxon3']//child::div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-n6v787 r-1e081e0 r-oyd9sg']")
	List<WebElement> cont_ListOfCountries;
	@FindBy(xpath = "//input[contains(@data-testid,'city-inputbox-contact-details')]")
	WebElement cont_City;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-18u37iz r-1e081e0 r-oyd9sg']//child::div[1]")
	List<WebElement> contSelectCodeList;

	@FindBy(css = "div#pax-item-MCFBRFQ-")
	WebElement div_PaxInfo;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1ugchlj r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-19554kt r-184en5c']")
	WebElement passInfo_Title;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-1w50u8q r-u8s1d r-19554kt r-8fdsdq']//child::div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar']")
	List<WebElement> passInfo_ListOfTitles;
	// @FindBy(xpath =
	// "//input[contains(@data-testid,'traveller-0-first-traveller-info-input-box')]")
	@FindBy(xpath = "//input[contains(@data-testid,'first-traveller-info-input-box')]")
	WebElement passInfo_FirstName;
	// @FindBy(xpath =
	// "//input[contains(@data-testid,'traveller-0-last-traveller-info-input-box')]")
	@FindBy(xpath = "//input[contains(@data-testid,'last-traveller-info-input-box')]")
	WebElement passInfo_LastName;

	@FindBy(xpath = "//div[contains(@data-testid,'sc-member-mobile-number-country-selection')]")
	WebElement memNumContSelect;
	@FindBy(xpath = "//input[contains(@data-testid,'sc-member-mobile-number-input-box')]")
	WebElement passInfo_MobNumber;
	@FindBy(xpath = "//div[contains(@data-testid,'travel-info-cta')]")
	WebElement btn_Next;
	@FindBy(xpath = "//div[contains(@data-testid,'traveller-info-continue-cta')]")
	WebElement btn_Continue;

	// Webelements located are used for filling details in Passenger Information
	// section for Infant
	@FindBy(xpath = "(//div[contains(@data-testid,'infant-information')])[1]")
	WebElement passInfo_infantTitle;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-u8s1d r-13qz1uu r-8fdsdq']//child::div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar']")
	List<WebElement> passInfo_ListOfInfantTitles;
	@FindBy(xpath = "//input[contains(@data-testid,'first-traveller-0-infant-information')]")
	WebElement passInfo_infantFirstName;
	@FindBy(xpath = "//input[contains(@data-testid,'last-traveller-0-infant-information')]")
	WebElement passInfo_infantLastName;
	@FindBy(xpath = "//input[contains(@data-testid,'date-of-birth')]")
	WebElement passInfo_infantDOB;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-12zupyf r-1otgn73']//div")
	List<WebElement> infantDOB_Years;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-ymp9ed r-1i8plt1 r-1rnoaur r-m611by r-4ueuch']")
	WebElement div_dobMonths;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-12zupyf r-1otgn73']//div")
	List<WebElement> infantDOB_Months;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73']//div")
	List<WebElement> infantDOB_Days;
	@FindBy(xpath = "(//div[contains(@data-testid,'infant-information')])[2]")
	WebElement field_infantTravWith;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-u8s1d r-13qz1uu r-8fdsdq']//child::div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar']")
	List<WebElement> list_infantTravWith;

	// Performing actions on WebElements of the Passenger Info Page for filling
	// details in Booking - Contact Information section
	public void selectTitle(String title) {
		wait.until(ExpectedConditions.elementToBeClickable(field_Title));
		field_Title.click();
		for (WebElement ele : cont_ListOfTitles) {
			if (title.equalsIgnoreCase(ele.getText())) {
				ele.click();
				break;
			}
		}
	}

	public void setFirstName(String fname) {
		cont_FirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		cont_LastName.sendKeys(lname);
	}

	public void setContactNumber(String contNum) {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			PhoneNumber numberProto = phoneUtil.parse(contNum, "");
			int contCode = numberProto.getCountryCode();
			String countryCode = "+" + String.valueOf(contCode);
			long mobNum = numberProto.getNationalNumber();
			String mobNumber = String.valueOf(mobNum);
			cont_ContNumSelect.click();
			for (WebElement ele : contSelectCodeList) {
				String eleText = ele.getText();
				if (eleText.equals(countryCode)) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", ele);
					ele.click();
					break;
				}
			}
			cont_Number.sendKeys(mobNumber);
		} catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setContactEmail(String email) {
		cont_Email.sendKeys(email);
	}

	public void setCountry(String cont) {
		cont_Country.click();
		try {
			for (WebElement ele : cont_ListOfCountries) {
				if (cont.equalsIgnoreCase(ele.getText())) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", ele);
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Incorrect country is provided: " + e.toString());
		}
	}

	public void setCity(String city) {
		cont_City.sendKeys(city);
	}

	// Performing actions on web elements for filling details in Passenger
	// information section for Adult & Child
	public void selectPaxTitle(String title, String paxCategory) {
		js.executeScript("arguments[0].scrollIntoView(true);", div_PaxInfo);
		passInfo_Title.click();
		for (WebElement ele : passInfo_ListOfTitles) {
			if (title.equalsIgnoreCase(ele.getText())) {
				ele.click();
				break;
			} else
				System.out.println("Incorrect Title : " + title + ", for the passenger type: " + paxCategory);
		}
	}

	public void setPaxFirstName(String fname) {
		passInfo_FirstName.sendKeys(fname);
	}

	public void setPaxLastName(String lname) {
		passInfo_LastName.sendKeys(lname);
	}

	public void setPaxMobileNumber(String mobNum) {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			PhoneNumber numberProto = phoneUtil.parse(mobNum, "");
			int contCode = numberProto.getCountryCode();
			String countryCode = "+" + String.valueOf(contCode);
			long scNum = numberProto.getNationalNumber();
			String scmobNumber = String.valueOf(scNum);
			memNumContSelect.click();
			for (WebElement ele : contSelectCodeList) {
				String eleText = ele.getText();
				if (eleText.equals(countryCode)) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", ele);
					ele.click();
					break;
				}
			}
			passInfo_MobNumber.sendKeys(scmobNumber);
		} catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void clickContinue() {
		try {
			//Thread.sleep(2000);
			if (btn_Next.isEnabled()) {
				btn_Next.click();
			} else {
				js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_Continue);
				btn_Continue.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Performing actions on web elements for filling details in Passenger
	// information section for Infant
	public void selectInfantTitle(String title, String paxCategory) {
		passInfo_infantTitle.click();
		for (WebElement ele : passInfo_ListOfInfantTitles) {
			if (title.equalsIgnoreCase(ele.getText())) {
				ele.click();
				break;
			}
		}
	}

	public void setInfantFirstName(String fname) {
		passInfo_infantFirstName.sendKeys(fname);
	}

	public void setInfantLastName(String lname) {
		passInfo_infantLastName.sendKeys(lname);
	}

	public void setInfantDOB(String dob) {
		try {
			String day = dob.split("-")[0];
			String month = dob.split("-")[1];
			String year = dob.split("-")[2];
			passInfo_infantDOB.click();
			for (WebElement eleYear : infantDOB_Years) {
				if (year.equalsIgnoreCase(eleYear.getText())) {
					eleYear.click();
					break;
				}
			}

			for (WebElement eleMon : infantDOB_Months) {
				js.executeScript("arguments[0].scrollIntoViewIfNeeded();", div_dobMonths);
				if (month.contains(eleMon.getText())) {
					eleMon.click();
					break;
				}
			}

			for (WebElement eleDay : infantDOB_Days) {
				if (day.equalsIgnoreCase(eleDay.getText())) {
					eleDay.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void setInfantTravellingWith(String adultDetails) {
		field_infantTravWith.click();
		for (WebElement ele : list_infantTravWith) {
			if (adultDetails.equalsIgnoreCase(ele.getText())) {
				ele.click();
				break;
			} else
				System.out.println("Incorrect guardian details for the infant to travel with");
		}
	}

}
