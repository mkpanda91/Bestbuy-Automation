package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_010_TestFlightSearchWithNoFlights extends BaseDriverClass {

	HomePage home_pgObj;
	SearchResultsPage sr_pgObj;

	@Test(dataProvider = "NoResultsSearch", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.MINOR)
	@Feature("Search Flights")
	@Description("This test attempts to test the search for flights on a route which is not valid")
	public void testFlightSearchWithNoResults(String srcAirport, String destAirport, String day, String month, String year, String adultCount, String childCount, String curr) {
		try {
			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.setOneWayTrip();
			home_pgObj.clickFromCity();
			home_pgObj.setRegionAsIndia();
			home_pgObj.setFromCity(srcAirport);
			// homeObj.clickToCity();
			home_pgObj.setRegionAsIndia();
			home_pgObj.setToCity(destAirport);

			// onward journey date, passenger and currency setup
			home_pgObj.setDeptDate(day, month, year);
			home_pgObj.setAdultPassengers(adultCount);
			home_pgObj.setChildPassengers(childCount);
			home_pgObj.setCurrency(curr);
			home_pgObj.clickSearchFlight();

			// Search Page Interactions
			sr_pgObj = new SearchResultsPage(driver);

			String expectedMsg = "Unfortunately, there are no flights available.";
			String actualMsg = sr_pgObj.getSearchResultForNoFlights();
			if (actualMsg.equalsIgnoreCase(expectedMsg))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
