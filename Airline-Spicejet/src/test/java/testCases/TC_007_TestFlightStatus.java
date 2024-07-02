package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_007_TestFlightStatus extends BaseDriverClass {
	
	HomePage home_pgObj;
	List<WebElement> flightStatus;
	Boolean ifFlightDisplayed;
	Boolean statusResult;
	
	@Test(dataProvider = "FlightStatus", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Feature("Additional Features - Flight Status")
	@Description("This test attempts to fetch and check if the flight status are displayed correctly as per search criteria")
	public void testFlightStatus(String flightStatusDay, String srcAirport, String destAirport) {
		try {
			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.clickFlightStatusTab();
			home_pgObj.setDeptDtForFlightStatus(flightStatusDay);
			home_pgObj.setFromCityForFlightStatus(srcAirport);
			home_pgObj.setToCityForFlightStatus(destAirport);
			home_pgObj.clickSearchBooking();
			
			 flightStatus = home_pgObj.getFlightStatus();
			 ifFlightDisplayed = home_pgObj.checkIfFlightDisplayedForStatus();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
		// Get the text for status of flight displayed and if it matches expected then set boolean variable to true
		for (WebElement ele: flightStatus ) {
			String eleText = ele.getText();
		if (eleText.equalsIgnoreCase("Arrived") || eleText.equalsIgnoreCase("Cancelled") || eleText.equalsIgnoreCase("On Time"))
			statusResult = true;
		else statusResult = false;
		}
		if (ifFlightDisplayed && statusResult)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
}
