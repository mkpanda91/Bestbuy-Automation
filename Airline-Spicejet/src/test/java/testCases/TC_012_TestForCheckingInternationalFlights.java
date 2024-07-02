package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.AddOnsPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.PassengerInfoPage;
import pageObjects.PrepaymentPage;
import pageObjects.SearchResultsPage;
import pageObjects.SignUpPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_012_TestForCheckingInternationalFlights extends BaseDriverClass {

	HomePage home_pgObj;
	SignUpPage su_pgObj;
	DashboardPage dash_pgObj;
	SearchResultsPage sr_pgObj;
	PassengerInfoPage pi_pgObj;
	AddOnsPage addon_pgObj;
	PrepaymentPage prepay_pgObj;

	@Test(dataProvider = "InternationalFlightSearch", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Search Flights")
	@Description("This test attempts to search International flights on a route")
	public void testInternationalFlightSearch(String srcAirport, String destIntlAirport, String day, String month,
			String year, String adultCount, String curr) {
		try {
			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.setOneWayTrip();
			home_pgObj.clickFromCity();
			home_pgObj.setRegionAsIndia();
			home_pgObj.setFromCity(srcAirport);
			// homeObj.clickToCity();
			home_pgObj.setRegionAsInternational();
			home_pgObj.setToCityIntl(destIntlAirport);

			// onward journey date, passenger and currency setup
			home_pgObj.setDeptDate(day, month, year);
			home_pgObj.setAdultPassengers(adultCount);
			home_pgObj.setCurrency(curr);
			home_pgObj.clickSearchFlight();

			// Search Page Interactions
			sr_pgObj = new SearchResultsPage(driver);

			int noOfFlights = sr_pgObj.checkInternationalFlightsCount();
			String srcCity = sr_pgObj.getSourceCityFromResults();
			String destCity = sr_pgObj.getDestinationCityFromResults();

			if ((noOfFlights > 0) && (srcCity.equalsIgnoreCase(srcAirport))
					&& (destCity.equalsIgnoreCase(destIntlAirport)))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
