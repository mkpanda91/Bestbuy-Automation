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

@Listeners ({utilities.AllureTestListener.class})
public class TC_005_US_LoginTest extends BaseDriverClass {

	HomePage home;
	LoginPage login;
	MyAccountsPage macc;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Login")
	@Description("US Locale: This test attempts to test the login functionality in application")

	public void testLogin() {
		try {
			
			// Home Page Interactions
			home = new HomePage(driver);
			home.clickAccountLink();
			home.clickSignInButton();

			// Login Page Interactions
			login = new LoginPage(driver);
			login.setLoginEmail(p.getProperty("loginEmail"));
			login.setLoginPassword(p.getProperty("loginPassword"));
			login.clickLogin();
			
			// MyAccounts Page Interactions
			macc = new MyAccountsPage(driver);
			macc.clickMyAccountOption();
			String loginSuccessMsg = macc.getSuccessSignupMsg();
			macc.clickSignout();
			Assert.assertEquals(loginSuccessMsg, "View member benefits");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
