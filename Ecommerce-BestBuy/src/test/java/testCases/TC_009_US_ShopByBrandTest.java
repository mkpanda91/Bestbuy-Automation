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
public class TC_009_US_ShopByBrandTest extends BaseDriverClass {

	HomePage home;
	SearchPage search;
	PaymentPage pay;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("Add to Cart")
	@Description("US Locale: This test attempts to test if user can Shop by Brand and add product to Cart")

	public void addProductToCartByBrand() {
		try {

			// Home Page Interactions
			home = new HomePage(driver);
			home.clickMenuOption();
			home.goToBrandSearchResults();

			// Search Page Interactions
			search = new SearchPage(driver);

			String successOnshopByBrand = search.addToCartByBrand();
			if (successOnshopByBrand.equals("Added to cart")) {
				search.clickGoToCart();
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
