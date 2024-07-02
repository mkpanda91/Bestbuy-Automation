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
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_003_TestLoginUsingMobileNumber extends BaseDriverClass{

	HomePage home_pgObj;
	LoginPage login_pgObj;

	@Test(dataProvider = "MobileLogin", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Login")
	@Description("This test attempts to test the login functionality - using Mobile Number")
	public void testLoginUsingMobileNumber(String mobNum, String password,  String fName) {
		try {

			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.clickLogin();

			// Login Page Interactions
			login_pgObj = new LoginPage(driver);
			login_pgObj.loginUsingMobile(mobNum, password);

			String expectedSuccessMsg = "Hi " + fName;
			String loginSuccessMsg = login_pgObj.getSuccessLoginTxt();
			if (loginSuccessMsg.equalsIgnoreCase(expectedSuccessMsg))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
