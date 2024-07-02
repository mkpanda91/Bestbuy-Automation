package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
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
	Select sel;
	Actions at;
	JavascriptExecutor js;
	String parent;
	WebDriverWait wait;

	// Constructor used to initialize the driver & all page objects of Home Page
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

	// Locating WebElements for various fields under the Flights tab on the HomePage
	@FindBy(css = "a[href='https://spiceclub.spicejet.com/signup']")
	WebElement link_Signup;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[1]")
	WebElement link_Login;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73'])[1]")
	WebElement btn_OneWay;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73'])[2]")
	WebElement btn_RoundWay;

	@FindBy(css = "div[data-testid='to-testID-origin'] div:nth-of-type(2)>input")
	WebElement field_From;
	@FindBy(css = "div[data-testid='to-testID-destination'] div:nth-of-type(2)>input")
	WebElement field_To;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-ge9izo'])//descendant::div[4])[1]")
	WebElement reg_Ind;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-ge9izo'])//descendant::div[4])[2]")
	WebElement reg_Inter;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[@class='css-76zvg2 r-1xedbs3 r-ubezar']")
	List<WebElement> list_domAirportCodes;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']//div[@class='css-76zvg2 r-1xedbs3 r-ubezar']")
	List<WebElement> list_IntlAirportCodes;

	@FindBy(xpath = "//div[@data-testid='departure-date-dropdown-label-test-id']/child::div[2]")
	WebElement field_depDate;
	@FindBy(xpath = "//div[@data-testid='return-date-dropdown-label-test-id']/child::div[2]")
	WebElement field_retDate;
	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])")
	List<WebElement> monthList;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='circle']")
	WebElement rightArrow;
	@FindBy(xpath = "//div[@data-testid='undefined-calendar-picker']")
	WebElement div_calendarPicker;
	@FindBy(css = "div[class='css-1dbjc4n r-1g94qm0 r-1ah4tor'] div[class='css-1dbjc4n r-1loqt21 r-1otgn73']")
	WebElement cancel_calendarPicker;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n']//descendant::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")
	WebElement field_Passengers;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1kz6sp']//div[@class='css-76zvg2 r-homxoj r-adyw6z r-q4m81j'])[1]")
	WebElement count_adultPass;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1kz6sp']//div[@class='css-76zvg2 r-homxoj r-adyw6z r-q4m81j'])[2]")
	WebElement count_childPass;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1kz6sp']//div[@class='css-76zvg2 r-homxoj r-adyw6z r-q4m81j'])[3]")
	WebElement count_infantPass;

	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Adult-testID')])[2]")
	WebElement inc_adultPass;
	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Children-testID')])[2]")
	WebElement inc_childPass;
	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Infant-testID')])[2]")
	WebElement inc_infantPass;

	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Adult-testID')])[1]")
	WebElement dec_adultPass;
	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Children-testID')])[1]")
	WebElement dec_childPass;
	@FindBy(xpath = "(//div[contains(@class,'css-1dbjc4n')]//div[contains(@data-testid,'Infant-testID')])[1]")
	WebElement dec_infantPass;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")
	WebElement field_currency;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1habvwh r-1loqt21 r-1777fci r-1mi0q7o r-1yt7n81 r-m611by r-1otgn73']//child::div[@class='css-76zvg2 r-homxoj r-ubezar']")
	List<WebElement> listOfCurrency;

	@FindBy(xpath = "//div[contains(@data-testid, 'home-page-flight')]")
	WebElement btn_searchFlight;

	// Locating WebElements for various fields under the Flight Status tab on the
	// HomePage
	@FindBy(xpath = "//div[contains(@data-testid,'flight status')]")
	WebElement opt_flightStatus;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-8oi148 r-1777fci r-ymttw5 r-5njf8e r-1otgn73']")
	WebElement deptdt_FlightStatus;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-zso239 r-1g94qm0 r-h3f8nf r-u8s1d r-12kfsgm r-8fdsdq']//div[@class='css-76zvg2 r-qsz3a2 r-2t9rge r-1i10wst r-1kfrs79']")
	List<WebElement> list_deptDtOptions;
	@FindBy(xpath = "(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")
	WebElement fromCity_FlightStatus;
	@FindBy(xpath = "(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")
	WebElement ToCity_FlightStatus;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']")
	WebElement btn_SearchBooking;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-2t9rge r-adyw6z r-1kfrs79']")
	List<WebElement> info_FlightStatus;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-6ity3w']/div")
	List<WebElement> list_divFlightStatusResults;
	@FindBy(xpath = "//div[contains(@class,'r-1enofrn r-q4m81j r-tsynxw')]")
	List<WebElement> list_FlightStatus;

	// Locating WebElements for various fields under the CheckIn and Manage Booking
	// tab
	// on the HomePage
	@FindBy(xpath = "//div[contains(@data-testid,'check-in')]")
	WebElement opt_checkIn;
	@FindBy(xpath = "//div[contains(@data-testid,'manage booking')]")
	WebElement opt_manageBooking;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-18u37iz r-1ugchlj r-12kfsgm']/input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")
	WebElement pnrNumber;
	@FindBy(xpath = "//input[contains(@placeholder,'@spicejet.com')]")
	WebElement emailId;
	@FindBy(xpath = "//div[@class='css-76zvg2 css-cens5h r-jwli3a']")
	WebElement ele_textForCheckInAndManageBooking;

	// Performing actions on WebElements of the Home Page, used for Flight Searching
	// - for one way & round trip

	public void getParentWindowHandle() {
		parent = driver.getWindowHandle();
	}

	public void clickSignUp() {
		wait.until(ExpectedConditions.elementToBeClickable(link_Signup));
		link_Signup.click();
		goToSignUpWindow();
	}

	public void goToSignUpWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> I1 = allWindows.iterator();
		while (I1.hasNext()) {
			String childWindow = I1.next();
			if (!parent.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	public void clickLogin() {
		link_Login.click();
	}

	public void setOneWayTrip() {
		btn_OneWay.click();
	}

	public void setRoundTrip() {
		btn_RoundWay.click();
	}

	public void clickFromCity() {
		field_From.click();
	}

	public void clickToCity() {
		field_To.click();
	}

	public void setRegionAsIndia() {
		reg_Ind.click();
	}

	public void setRegionAsInternational() {
		reg_Inter.click();
	}

	public void setFromCity(String cityAirCode) {
		try {
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (NotFoundException e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setToCity(String cityAirCode) {
		try {
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript(
							"document.querySelector('.css-1dbjc4n.r-knv0ih.r-1k1q3bj.r-ql8eny.r-1dqxon3').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (Exception e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		}
	}

	public void setDeptDate(String Day, String Month, String Year) {
		String expMonthSel = Month + " " + Year;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		for (int i = 0; i <= monthList.size(); i += 2) {
			if (expMonthSel.equalsIgnoreCase(monthList.get(i).getText())
					|| expMonthSel.equalsIgnoreCase(monthList.get(i + 1).getText())) {
				driver.findElement(By.xpath("//div[contains(@data-testid,'month-" + Month + "-" + Year
						+ "')]//div[contains(@data-testid,'undefined-calendar-day-" + Day + "')]")).click();
				break;
			} else {
				js.executeScript("window.scrollBy(0,200)");
				rightArrow.click();
			}
		}
	}

	public void setReturnDate(String Day, String Month, String Year) {
		field_retDate.click();
		String expMonthSel = Month + " " + Year;
		field_retDate.click();
		for (int i = 0; i <= monthList.size(); i += 2) {
			if (expMonthSel.equalsIgnoreCase(monthList.get(i).getText())
					|| expMonthSel.equalsIgnoreCase(monthList.get(i + 1).getText())) {
				driver.findElement(By.xpath("//div[contains(@data-testid,'month-" + Month + "-" + Year
						+ "')]//div[contains(@data-testid,'undefined-calendar-day-" + Day + "')]")).click();
				break;
			} else {
				rightArrow.click();
			}
		}
	}

	public void setAdultPassengers(String adult) {
		field_Passengers.click();
		int adultCount = Integer.parseInt(count_adultPass.getText());
		int adultPax = Integer.parseInt(adult);
		while (adultPax != adultCount) {
			if (adultPax > adultCount) {
				inc_adultPass.click();
				adultCount++;
			} else if (adultPax < adultCount && adultPax > 0) {
				dec_adultPass.click();
				adultCount--;
			} else {
				System.out.println("Please provide a valid count of Adult passengers, which is greater than zero");
				break;
			}
		}
		field_Passengers.click();
	}

	public void setChildPassengers(String child) {
		field_Passengers.click();
		int childCount = Integer.parseInt(count_childPass.getText());
		int childPax = Integer.parseInt(child);
		while (childPax != childCount) {
			if (childPax > childCount) {
				inc_childPass.click();
				childCount++;
			} else if (childPax < childCount && childPax > 0) {
				dec_childPass.click();
				childCount--;
			} else {
				System.out.println("Please provide a valid count of Child passengers, which is greater than zero");
				break;
			}
		}
		field_Passengers.click();
	}

	public void setInfantPassengers(String infant, String adult) {
		field_Passengers.click();
		int infantCount = Integer.parseInt(count_infantPass.getText());
		int infantPax = Integer.parseInt(infant);
		int adultCount = Integer.parseInt(adult);
		if (infantPax <= adultCount) {
			while (infantPax != infantCount) {
				if (infantPax > infantCount) {
					inc_infantPass.click();
					infantCount++;
				} else if (infantPax < infantCount && infantPax > 0) {
					dec_infantPass.click();
					infantCount--;
				} else {
					System.out.println("Please provide a valid count of Infant passengers, which is greater than zero");
					break;
				}
			}
		} else {
			System.out
					.println("Number of infants travelling cannot be more than Number of adults travelling with them");
			return;
		}
		field_Passengers.click();
	}

	public void setCurrency(String currCode) {
		try {
			field_currency.click();
			for (WebElement ele : listOfCurrency) {
				if (currCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", ele);
					ele.click();
					break;
				} else
					System.out.println("The Currency with the currency code is not found. Please input a valid code.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void clickSearchFlight() {
		btn_searchFlight.click();
	}

	// Actions below are used for checking Flight Status
	public void clickFlightStatusTab() {
		opt_flightStatus.click();
	}

	public void setDeptDtForFlightStatus(String dtOption) {
		deptdt_FlightStatus.click();
		for (int i = 0; i < list_deptDtOptions.size(); i++) {
			if (list_deptDtOptions.get(i).getText().contains(dtOption)) {
				list_deptDtOptions.get(i).click();
				break;
			}
		}
	}

	public void setFromCityForFlightStatus(String cityAirCode) {
		try {
			fromCity_FlightStatus.click();
			reg_Ind.click();
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (NotFoundException e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setToCityForFlightStatus(String cityAirCode) {
		try {
			reg_Ind.click();
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (NotFoundException e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickSearchBooking() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		btn_SearchBooking.click();
	}

	public List<WebElement> getFlightStatus() {
		wait.until(ExpectedConditions.visibilityOfAllElements(list_divFlightStatusResults));
		if (list_divFlightStatusResults.size() > 0)
			return list_FlightStatus;
		else
			return null;
	}

	public Boolean checkIfFlightDisplayedForStatus() {
		wait.until(ExpectedConditions.visibilityOfAllElements(list_divFlightStatusResults));
		if (list_divFlightStatusResults.size() > 0)
			return true;
		else
			return false;
	}

	// Actions below are used for checking Check-In and Manage Booking
	public void clickManageBookingTab() {
		opt_manageBooking.click();
	}

	public void clickCheckInTab() {
		opt_checkIn.click();
	}

	public void getMessageForCheckinAndManageBooking(String pnr, String email) {
		pnrNumber.sendKeys(pnr);
		emailId.sendKeys(email);
	}

	public String getMessageAfterSearchBooking() {
		return ele_textForCheckInAndManageBooking.getText();
	}

	// Actions below are used for selecting From & To International Airport
	public void setFromCityIntl(String cityAirCode) {
		try {
			for (WebElement ele : list_IntlAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (NotFoundException e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void setToCityIntl(String cityAirCode) {
		try {
			for (WebElement ele : list_IntlAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript("document.querySelector('.css-1dbjc4n.r-19yat4t.r-1rt2jqs').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			for (WebElement ele : list_domAirportCodes) {
				if (cityAirCode.equalsIgnoreCase(ele.getText())) {
					js.executeScript(
							"document.querySelector('.css-1dbjc4n.r-knv0ih.r-1k1q3bj.r-ql8eny.r-1dqxon3').scrollIntoView();",
							ele);
					ele.click();
				}
			}
		} catch (Exception e) {
			System.out.println("The Airport with the airport code is not found. Please search for a valid code.");
		}
	}

}
