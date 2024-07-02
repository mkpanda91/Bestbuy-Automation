package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.PassengerInfoPage;
import pageObjects.PrepaymentPage;
import pageObjects.AddOnsPage;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import pageObjects.SignUpPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_005_TestOneWayBooking extends BaseDriverClass {

	HomePage home_pgObj;
	SignUpPage su_pgObj;
	SearchResultsPage sr_pgObj;
	PassengerInfoPage pi_pgObj;
	AddOnsPage addon_pgObj;
	PrepaymentPage prepay_pgObj;
	String resultText;

	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Feature("Booking")
	@Description("This test attempts to test the functionality of booking one way flight tickets")
	public void testOneWayBooking() {
		try {
			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.setOneWayTrip();
			home_pgObj.clickFromCity();
			home_pgObj.setRegionAsIndia();
			home_pgObj.setFromCity(p.getProperty("OnwardSource"));
			// homeObj.clickToCity();
			home_pgObj.setRegionAsIndia();
			home_pgObj.setToCity(p.getProperty("OnwardDestination"));
			
			//onward journey date, passenger and currency setup
			home_pgObj.setDeptDate(p.getProperty("OnwardTravelDay"), p.getProperty("OnwardTravelMonth"),
					p.getProperty("OnwardTravelYear"));
			home_pgObj.setAdultPassengers(p.getProperty("AdultPaxCount"));
			home_pgObj.setChildPassengers(p.getProperty("ChildPaxCount"));
			home_pgObj.setInfantPassengers(p.getProperty("InfantPaxCount"),p.getProperty("AdultPaxCount"));
			home_pgObj.setCurrency(p.getProperty("Currency"));
			home_pgObj.clickSearchFlight();

			// Search Page Interactions
			sr_pgObj = new SearchResultsPage(driver);
			sr_pgObj.selectDeptFlight(p.getProperty("OnwardFaretype"));
			sr_pgObj.clickContinue();

			// Passenger Info Page Interactions
			pi_pgObj = new PassengerInfoPage(driver);
			pi_pgObj.selectTitle(p.getProperty("contactTitle"));
			pi_pgObj.setFirstName(p.getProperty("contactFirstName"));
			pi_pgObj.setLastName(p.getProperty("contactLastName"));
			pi_pgObj.setContactNumber(p.getProperty("contactNumber"));
			pi_pgObj.setContactEmail(p.getProperty("contactEmail"));
			pi_pgObj.setCountry(p.getProperty("country"));
			pi_pgObj.setCity(p.getProperty("city"));

			// Filling the Adult Passenger information
			pi_pgObj.selectPaxTitle(p.getProperty("AdPax1_title"), p.getProperty("Pax_category1"));
			pi_pgObj.setPaxFirstName(p.getProperty("AdPax1_fname"));
			pi_pgObj.setPaxLastName(p.getProperty("AdPax1_lname"));
			pi_pgObj.setPaxMobileNumber(p.getProperty("AdPax1_mobnum"));
			pi_pgObj.clickContinue();
			// Filling the Child Passenger information
			pi_pgObj.selectPaxTitle(p.getProperty("ChPax1_title"), p.getProperty("Pax_category2"));
			pi_pgObj.setPaxFirstName(p.getProperty("ChPax1_fname"));
			pi_pgObj.setPaxLastName(p.getProperty("ChPax1_lname"));
			pi_pgObj.clickContinue();
			// Filling the Infant Passenger information
			pi_pgObj.selectInfantTitle(p.getProperty("InfPax1_title"), p.getProperty("Pax_category3"));
			pi_pgObj.setInfantFirstName(p.getProperty("InfPax1_fname"));
			pi_pgObj.setInfantLastName(p.getProperty("InfPax1_lname"));
			pi_pgObj.setInfantDOB(p.getProperty("InfPax1_dob"));
			pi_pgObj.setInfantTravellingWith(p.getProperty("InfPax1_TravelWith"));
			pi_pgObj.clickContinue();

			// Add-Ons Page Interactions
			addon_pgObj = new AddOnsPage(driver);
			addon_pgObj.chooseOnewayTripAddOn(p.getProperty("OnwardFaretype"), p.getProperty("AdultPaxCount"), p.getProperty("ChildPaxCount"));
			addon_pgObj.clickContinue();

			// Prepayment Page Interactions
			prepay_pgObj = new PrepaymentPage(driver);
			prepay_pgObj.setCardNumber(p.getProperty("cardNumber"));
			prepay_pgObj.setCardName(p.getProperty("contactFirstName") + " " + p.getProperty("contactLastName"));
			prepay_pgObj.setCardExpiryMonth(p.getProperty("cardExpMonth"));
			prepay_pgObj.setCardExpiryYear(p.getProperty("cardExpYear"));
			prepay_pgObj.setCardSecurity(p.getProperty("cardCVV"));
			resultText = prepay_pgObj.clickContinue();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
		if (resultText.equalsIgnoreCase("Invalid Card Details"))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
}
