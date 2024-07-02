package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_001_TestSignUp extends BaseDriverClass {

	HomePage home_pgObj;
	SignUpPage su_pgObj;
	DashboardPage dash_pgObj;

	@Test(dataProvider = "SignUp", dataProviderClass = utilities.DataProviders.class)
	@Severity(SeverityLevel.CRITICAL)
	@Feature("SignUp")
	@Description("This test attempts to test the signup functionality in the application")
	public void testSignUp(String fName, String lName, String dob, String mobNum, String email, String password) {
		try {

			// Home Page Interactions
			home_pgObj = new HomePage(driver);
			home_pgObj.getParentWindowHandle();
			home_pgObj.clickSignUp();

			// SignUp Page Interactions
			su_pgObj = new SignUpPage(driver);
			su_pgObj.setTitle();
			su_pgObj.setFirstName(fName);
			su_pgObj.setLastName(lName);
			su_pgObj.setCountry();
			su_pgObj.setDoB(dob);
			su_pgObj.setMobileNumber(mobNum);
			su_pgObj.setEmail(email);
			su_pgObj.setPassword(password);
			su_pgObj.setConfirmPassword(password);
			su_pgObj.submitSignup();

			String txt_signupFailure = "OTP Verification";
			String txt_postSignup = su_pgObj.getPostSignUpVerification();
			
			//This testcase is expected to fail as there is an OTP popup expected, which is not handled
			if (txt_postSignup.equalsIgnoreCase(txt_signupFailure))
				Assert.assertTrue(false);
			else {
				// Dashboard Page Interactions
				dash_pgObj = new DashboardPage(driver);
				dash_pgObj.userLogout();
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
