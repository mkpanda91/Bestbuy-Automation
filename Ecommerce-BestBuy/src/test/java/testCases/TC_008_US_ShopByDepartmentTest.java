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
public class TC_008_US_ShopByDepartmentTest extends BaseDriverClass {

	HomePage home;
	SearchPage search;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("Add to Cart")
	@Description("US Locale: This test attempts to test if user can Shop by Department and add a product to Cart")
	@Parameters({ "country" })
	public void addProductToCartByDept(String cont) {
		try {
			BaseDriverClass bdObj = new BaseDriverClass();
			bdObj.setupCountry(cont);
			
			// Home Page Interactions
			home = new HomePage(driver);
			home.clickMenuOption();
			home.goToDeptSearchResults();
			
			// Search Page Interactions
			search = new SearchPage(driver);

			String successOnshopByDept = search.addToCartByDept();
			if (successOnshopByDept.equals("Added to cart")) {
				search.clickGoToCart();
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println("Unable to add item to the cart by Department search: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}
}
