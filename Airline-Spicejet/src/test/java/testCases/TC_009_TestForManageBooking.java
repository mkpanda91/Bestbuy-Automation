package testCases;

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
public class TC_009_TestForManageBooking extends BaseDriverClass {

	HomePage home_pgObj;
	String expectedText;
	String actualText;

	@Test(dataProvider = "PNRData", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Feature("Additional Features - Manage Booking")
	@Description("This test attempts to check the message displayed, when incorrect PNR is provided during Manage Booking")
	public void testManageBooking(String pnrNumber, String email) {
		try {
			// "Unable to fetch your booking. Please check the inputs you have provided and
			// try again.";
			expectedText = "Unable to fetch your booking.";

			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.clickManageBookingTab();
			home_pgObj.getMessageForCheckinAndManageBooking(pnrNumber, email);
			home_pgObj.clickSearchBooking();
			actualText = home_pgObj.getMessageAfterSearchBooking();

			if (actualText.contains(expectedText))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			Assert.fail();
		}
	}

}
