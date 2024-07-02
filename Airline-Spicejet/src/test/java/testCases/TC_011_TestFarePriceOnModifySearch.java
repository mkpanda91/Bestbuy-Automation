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
public class TC_011_TestFarePriceOnModifySearch extends BaseDriverClass{
	
	HomePage home_pgObj;
	SearchResultsPage sr_pgObj;

	@Test(dataProvider = "ModifySearch", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Feature("Search Flights")
	@Description("This test attempts to test the search for flights by modifying initial search criteria")
	public void testFarePriceOnModifySearch(String srcAirport, String destAirport, String day, String month, String year, String adultCount, String childCount, String curr) {
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
			home_pgObj.setCurrency(curr);
			home_pgObj.clickSearchFlight();

			// Search Page Interactions
			sr_pgObj = new SearchResultsPage(driver);
			String initialPrice = sr_pgObj.getFarePrice();
			
			//Modify the search and check the revised price
			sr_pgObj.clickModifySearch();
			sr_pgObj.setChildPassengers(childCount);
			sr_pgObj.clickSearchFlight();
			String finalPrice = sr_pgObj.getFarePrice();

			if (!finalPrice.equalsIgnoreCase(initialPrice))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}

