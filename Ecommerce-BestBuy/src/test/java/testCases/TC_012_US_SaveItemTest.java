package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseDriverClass;

@Listeners({ utilities.AllureTestListener.class })
public class TC_012_US_SaveItemTest extends BaseDriverClass {
	HomePage home;
	SearchPage search;

	@Test
	@Severity(SeverityLevel.MINOR)
	@Feature("Wishlisting")
	@Description("US Locale: This test attempts to test if products saved are displayed in My Saved Items section")

	public void saveSearchedItems() {
		try {

			// Home Page Interactions
			home = new HomePage(driver);
			home.keywordSearchAndClick("mouse");

			// Search Page Interactions
			search = new SearchPage(driver);
			String[] strArr = search.saveItem();
			if (strArr[0].equalsIgnoreCase(strArr[1]))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
