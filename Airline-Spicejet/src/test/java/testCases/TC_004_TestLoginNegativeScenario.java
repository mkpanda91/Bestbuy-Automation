package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_004_TestLoginNegativeScenario extends BaseDriverClass {

	HomePage home_pgObj;
	LoginPage login_pgObj;
	DashboardPage dash_pgObj;

	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Feature("Login")
	@Description("This test attempts covers the negative scenario testing for login with mutiple test data combinations")
	public void test_login_MultiData(String email, String password, String expData) {

		try {

			// Home page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.clickLogin();

			// Login page Interactions
			login_pgObj = new LoginPage(driver);
			login_pgObj.loginUsingEmail(email, password);

			// Dashboard Page Interactions
			dash_pgObj = new DashboardPage(driver);

//			String textExpected[] = { "Invalid Username/Password", "Please enter a valid email address",
//					"Please enter a valid password" };
			Boolean targetElement = login_pgObj.isLoginButtonPresent();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			if (expData.equalsIgnoreCase("Valid")) {
				if (targetElement == false) {
					dash_pgObj.userLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expData.equalsIgnoreCase("Invalid")) {
				if (targetElement == true) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
