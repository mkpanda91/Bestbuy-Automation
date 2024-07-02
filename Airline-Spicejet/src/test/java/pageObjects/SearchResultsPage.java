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

public class SearchResultsPage {

	private WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	String parent;

	//Constructor used to initialize the driver & all page objects of SearchResults Page
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	// Locating WebElements on the SearchResults Page
	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-1x35g6 r-1kfrs79 r-15d164r r-38x2cy']")
	WebElement txt_NoFlights;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1xdf14d'])[1]")
	WebElement div_deptFlightResults;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1xdf14d'])[2]")
	WebElement div_retFlightResults;

	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[1]//*[name()='circle' and contains(@fill,'FFF')])[1]")
	WebElement dept_btn_Spicesaver;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[1]//*[name()='circle' and contains(@fill,'FFF')])[2]")
	WebElement dept_btn_Spiceflex;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[1]//*[name()='circle' and contains(@fill,'FFF')])[3]")
	WebElement dept_btn_Spicemax;

	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[2]//*[name()='circle' and contains(@fill,'FFF')])[1]")
	WebElement ret_btn_Spicesaver;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[2]//*[name()='circle' and contains(@fill,'FFF')])[2]")
	WebElement ret_btn_Spiceflex;
	@FindBy(xpath = "((//div[@class='css-1dbjc4n r-1xdf14d'])[2]//*[name()='circle' and contains(@fill,'FFF')])[3]")
	WebElement ret_btn_Spicemax;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-1x35g6 r-1kfrs79'])[3]")
	WebElement ele_farePrice;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement btn_Continue;
	
	// Webelements for Modify Search functionality
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-ymp9ed r-1j3t67a r-1w50u8q r-ah5dr5 r-1otgn73 r-1n20pny']")
	WebElement btn_modifySearch;
	@FindBy(xpath="css-1dbjc4n r-184aecr r-6koalj r-18u37iz r-1iud8zs r-1lxl8vk r-ie3wiu")
	WebElement modal_modifySearch;
	@FindBy(xpath="//div[contains(@data-testid,'home-page-travellers')]")
	WebElement popup_Passengers;
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
	@FindBy(xpath = "//div[contains(@data-testid, 'home-page-flight')]")
	WebElement btn_searchFlight;
	
	// WebElements for searching International flights
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1xdf14d'])[1]/div")
	List<WebElement> flightsInResults;
	@FindBy(xpath="//div[@class='css-76zvg2 r-homxoj r-ubezar']")
	List<WebElement> flightsSrcAndDest;

	
	//Performing actions on WebElements of the SearchResults Page
	public String getSearchResultForNoFlights() {
		return txt_NoFlights.getText();
	}

	public String getFarePrice() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele_farePrice));
		String text = (ele_farePrice.getText());
		String price = text.replace(" ", "");
		return price;
	}

	public void selectDeptFlight(String fareType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Thread.sleep(7000);
			js.executeScript("arguments[0].scrollIntoView();", div_deptFlightResults);

			if (fareType.equalsIgnoreCase("SpiceSaver")) {
				wait.until(ExpectedConditions.elementToBeClickable(dept_btn_Spicesaver));
				dept_btn_Spicesaver.click();
			} else if (fareType.equalsIgnoreCase("SpiceFlex")) {
				wait.until(ExpectedConditions.elementToBeClickable(dept_btn_Spiceflex));
				dept_btn_Spiceflex.click();
			} else if (fareType.equalsIgnoreCase("SpiceMax")) {
				wait.until(ExpectedConditions.elementToBeClickable(dept_btn_Spicemax));
				dept_btn_Spicemax.click();
			} else {
				System.out.println("Invalid Faretype for a successful booking. Please retry again.");
			}
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void selectReturnFlight(String fareType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView();", div_retFlightResults);

			if (fareType.equalsIgnoreCase("SpiceSaver")) {
				wait.until(ExpectedConditions.elementToBeClickable(ret_btn_Spicesaver));
				ret_btn_Spicesaver.click();
			} else if (fareType.equalsIgnoreCase("SpiceFlex")) {
				wait.until(ExpectedConditions.elementToBeClickable(ret_btn_Spiceflex));
				ret_btn_Spiceflex.click();
			} else if (fareType.equalsIgnoreCase("SpiceMax")) {
				wait.until(ExpectedConditions.elementToBeClickable(ret_btn_Spicemax));
				ret_btn_Spicemax.click();
			} else {
				System.out.println("Invalid Faretype for a successful booking. Please retry again.");
			}
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void clickContinue() {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(btn_Continue));
			Thread.sleep(4000);
			if (btn_Continue.isEnabled())
				btn_Continue.click();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}

	
	// Performing actions on webelements for  Modify Search functionality
	public void setAdultPassengers(String adult) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(popup_Passengers)).click();
		//popup_Passengers.click();
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
		popup_Passengers.click();
	}

	public void setChildPassengers(String child) throws InterruptedException {
		//Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(popup_Passengers)).click();
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
		popup_Passengers.click();
	}

	public void setInfantPassengers(String infant, String adult) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(popup_Passengers)).click();
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
		popup_Passengers.click();
	}

	public void clickModifySearch() {
		btn_modifySearch.click();
	}
	
	public void clickSearchFlight() {
		btn_searchFlight.click();
	}
	
	
	// Performing actions for searching International flights
	public int checkInternationalFlightsCount()
	{
		return flightsInResults.size();
	}
	
	public String getSourceCityFromResults()
	{
		return flightsSrcAndDest.get(0).getText();
	}
	
	public String getDestinationCityFromResults()
	{
		return flightsSrcAndDest.get(1).getText();
	}

}
