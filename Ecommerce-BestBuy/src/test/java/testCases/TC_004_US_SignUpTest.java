package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.MyAccountsPage;
import pageObjects.SignUpPage;
import testBase.BaseDriverClass;

@Listeners ({utilities.AllureTestListener.class})
public class TC_004_US_SignUpTest extends BaseDriverClass{

	HomePage home;
	SignUpPage signup;
	MyAccountsPage macc;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Feature("SignUp")
	@Description("US Locale: This test attempts to test the SignUp functionality in application")
	@Parameters({ "country" })
	public void testSignUp(String cont) {
		try {
			BaseDriverClass bdObj = new BaseDriverClass();
			bdObj.setupCountry(cont);
			
			// Home Page Interactions
			home = new HomePage(driver);
			home.clickAccountLink();
			home.clickCreateAccountButton();

			// SignUp Page Interactions
			signup = new SignUpPage(driver);
			signup.setFirstName(p.getProperty("firstName"));
			signup.setLastName(p.getProperty("lastName"));
			signup.setEmail(p.getProperty("email"));
			signup.setPassword(p.getProperty("password"));
			signup.setConfirmPassword(p.getProperty("password"));
			signup.setMobileNumber(p.getProperty("mobileNumber"));
			signup.clickCreateAccount();

			// MyAccounts Page Interactions
			macc = new MyAccountsPage(driver);
			String signupSuccessMsg = macc.getSuccessSignupMsg();
			macc.clickSignout();
			Assert.assertEquals(signupSuccessMsg, "Hi, Cheryl");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
