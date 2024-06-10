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
import pageObjects.SearchPage;
import testBase.BaseDriverClass;

@Listeners({utilities.AllureTestListener.class})
public class TC_002_CA_ShopByBrandAndAddToCartTest extends BaseDriverClass {
	HomePage home;
	SearchPage search;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("Add to Cart")
	@Description("CA Locale: This test attempts to test if user can Shop by Brand and add product to Cart")
	@Parameters({ "country" })
	public void addProductToCartByBrand(String cont) {
		try {
			BaseDriverClass bdObj = new BaseDriverClass();
			bdObj.setupCountry(cont);

			// Home Page Interactions
			home = new HomePage(driver);
			home.ca_goToBrandSearchResults();

			// Search Page Interactions
			search = new SearchPage(driver);
			String expectedMsg = "This item has been added to your cart.";
			String actualMsg = search.ca_addToCartByBrand();
			Assert.assertEquals(actualMsg, expectedMsg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}
	}
}
