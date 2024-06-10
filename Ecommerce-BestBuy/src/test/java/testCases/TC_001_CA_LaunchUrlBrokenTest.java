package testCases;

import java.net.HttpURLConnection;

import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import testBase.BaseDriverClass;

@Listeners({utilities.AllureTestListener.class})
public class TC_001_CA_LaunchUrlBrokenTest extends BaseDriverClass {
	HomePage home;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Feature("General - Website links")
	@Description("CA Locale: This test attempts to test if the lauched application url is Broken")
	@Parameters ({"country"})
	public void testLaunchUrlIfBroken(String cont) {
		try {
	
			BaseDriverClass bdObj = new BaseDriverClass();
			bdObj.setupCountry(cont);
			
			// Home Page Interaction
			home = new HomePage(driver);
			String url = home.ca_getSiteUrl();

			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.connect();

			// Get The Response Code & if it is Greater Than 400, then It Is Broken Link
			int code = httpConn.getResponseCode();
			if (code >= 400) {
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
