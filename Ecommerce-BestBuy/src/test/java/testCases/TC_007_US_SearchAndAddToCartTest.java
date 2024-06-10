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

@Listeners ({utilities.AllureTestListener.class})
public class TC_007_US_SearchAndAddToCartTest extends BaseDriverClass {
	HomePage home;
	SearchPage search;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Add to Cart")
	@Description("US Locale: This test attempts to test if user can search and add product to Cart")
	@Parameters({ "country" })
	public void addProductToCartBySearch(String cont) {
		try {
			BaseDriverClass bdObj = new BaseDriverClass();
			bdObj.setupCountry(cont);
			
			// Home Page Interactions
			home = new HomePage(driver);
			home.keywordSearchAndClick("airpods");
			
			// Search Page Interactions
			search = new SearchPage(driver);
			String successOnshopBysearch = search.addToCartBySearch();
			if (successOnshopBysearch.equals("Added to cart")) {
				search.clickGoToCart();
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println("Unable to add item to the cart by keyword search: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}
}
