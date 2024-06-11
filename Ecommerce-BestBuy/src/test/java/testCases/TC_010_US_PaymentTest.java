package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.PaymentPage;
import pageObjects.SearchPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_010_US_PaymentTest extends BaseDriverClass {

	HomePage home;
	SearchPage search;
	PaymentPage pay;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Payment")
	@Description("US Locale: This test attempts to test if user can place order with dummy payment information")

	public void addProductToCartAndPayment() {
		try {

			// Home Page Interactions
			home = new HomePage(driver);
			home.clickMenuOption();
			home.goToBrandSearchResults();

			// Search Page Interactions
			search = new SearchPage(driver);
			search.addToCartByBrand();
			
			//Payment Page Interactions
			pay = new PaymentPage(driver);
			pay.setContactInfoForPayment(p.getProperty("email"), p.getProperty("mobileNumber"));
			pay.setPaymentDetails(p.getProperty("cardNumber"), p.getProperty("cardExpMonth"),
					p.getProperty("cardExpYear"), p.getProperty("cardCVV"));
			pay.setBillingDetails(p.getProperty("firstName"), p.getProperty("lastName"), p.getProperty("billingAddr"),
					p.getProperty("billingCity"), p.getProperty("billingState"), p.getProperty("billingZip"));
			String paymentMsg = pay.checkOut();
			String paymentFailureMsg = "Unfortunately, we were unable to process";
			if (paymentMsg.contains(paymentFailureMsg)) {
				System.out.println("Order is not placed as expected due to Incorrect payment");
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}
	}
}
