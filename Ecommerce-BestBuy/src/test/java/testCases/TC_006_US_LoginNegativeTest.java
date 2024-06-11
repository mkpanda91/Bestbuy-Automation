package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_006_US_LoginNegativeTest extends BaseDriverClass {

	HomePage home;
	LoginPage login;
	MyAccountsPage macc;

	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Feature("Login")
	@Description("US Locale: This test attempts covers the negative scenario testing for login with mutiple test data combinations")
	public void test_login_MultiData(String email, String password, String expData) {

		try {

			// Home page Interactions
			home = new HomePage(driver);
			home.clickAccountLink();
			home.clickSignInButton(); // Login button under Account

			// Login page Interactions
			login = new LoginPage(driver);
			login.setLoginEmail(email);
			login.setLoginPassword(password);
			login.clickLogin(); // Login Button on Login page

			// My Account Page
			macc = new MyAccountsPage(driver);
			Boolean targetElement = macc.isSuccessLoginExists();

			if (expData.equalsIgnoreCase("Valid")) {
				if (targetElement == true) {
					macc.clickSignout();
					Assert.assertTrue(true);
				} else {
					login.returnToPreviousPage();
					Assert.assertTrue(false);
				}
			}

			if (expData.equalsIgnoreCase("Invalid")) {
				if (targetElement == true) {
					macc.clickSignout();
					Assert.assertTrue(false);
				} else {
					login.returnToPreviousPage();
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

	}
}
