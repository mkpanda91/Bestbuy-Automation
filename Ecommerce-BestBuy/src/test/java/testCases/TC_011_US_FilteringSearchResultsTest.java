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
public class TC_011_US_FilteringSearchResultsTest extends BaseDriverClass {
	HomePage home;
	SearchPage search;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("Search")
	@Description("US Locale: This test attempts to test if user can filter the Search Results")

	public void filterSearchResults() {
		try {

			// Home Page Interactions
			home = new HomePage(driver);
			home.keywordSearchAndClick("mouse");

			// Search Page Interactions
			search = new SearchPage(driver);
			String[] strArr = search.filterSearchResults();
			if (strArr[0].equalsIgnoreCase(strArr[1]))
				Assert.assertTrue(false);
			else
				Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
