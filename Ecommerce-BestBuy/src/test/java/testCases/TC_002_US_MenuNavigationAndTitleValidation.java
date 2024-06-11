package testCases;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import testBase.BaseDriverClass;

@Listeners ({utilities.AllureTestListener.class})
public class TC_002_US_MenuNavigationAndTitleValidation extends BaseDriverClass {

	HomePage home;
	List<WebElement> leftNav_MenuElements;
	String[] leftNav_MenuElementsList;
	JavascriptExecutor js;
	int counter = 0;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("General - Website links")
	@Description("US Locale: This test attempts to test the navigation for the left menubar options")

	public void testMenuNavigationAndTitle() {
		try {
			
			// Home Page Interactions
			home = new HomePage(driver);
			js = (JavascriptExecutor) driver;
			leftNav_MenuElements = home.getLeftNavigationMenuElements();
			leftNav_MenuElementsList = new String[leftNav_MenuElements.size()];
			for (int i = 0; i < leftNav_MenuElements.size(); i++) {
				leftNav_MenuElements = home.getLeftNavigationMenuElements();
				leftNav_MenuElementsList[i] = leftNav_MenuElements.get(i).getAttribute("href");

				// System.out.println(menuElementText);
				driver.navigate().to(leftNav_MenuElementsList[i]);
				String currentUrl = driver.getCurrentUrl();
				driver.navigate().back();
				if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
					counter++;
				} else {
					String menuElementText = (String) js.executeScript("return arguments[0].innerHTML;",
							leftNav_MenuElements.get(i));
					System.out.println(
							"Menu link: " + "'" + menuElementText + "'" + " is not being navigated successfully");
				}
			}
			if (counter == leftNav_MenuElementsList.length)
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
