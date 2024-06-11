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
import pageObjects.MyAccountsPage;
import pageObjects.SignUpPage;
import testBase.BaseDriverClass;

@Listeners ({utilities.AllureTestListener.class})
public class TC_003_US_CheckBottomLinksTest extends BaseDriverClass {

	HomePage home;
	SignUpPage signup;
	MyAccountsPage macc;
	JavascriptExecutor js;
	List<WebElement> footerElements;
	int counter = 0;

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Feature("General - Website links")
	@Description("US Locale: This test attempts to test Bottom Footer links")

	public void testSignUp() {
		try {
			
			// Home Page Interaction
			home = new HomePage(driver);
			js = (JavascriptExecutor) driver;
			// Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			footerElements = home.getFooterElements();
			String[] footerElementsList = new String[footerElements.size()];
			for (int i = 0; i < footerElements.size(); i++) {
				footerElementsList[i] = footerElements.get(i).getAttribute("href");
			}

			for (int i = 0; i < footerElements.size(); i++) {
				driver.navigate().to(footerElementsList[i]);
				String currentUrl = driver.getCurrentUrl();
				driver.navigate().back();
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				WebElement footerElement = home.getFooterElements().get(i);
				if (!currentUrl.equalsIgnoreCase(expectedUrl))
					counter++;
				else
					System.out.println("Footer link: " + "'" + footerElement.getText() + "'"
							+ " is not being navigated successfully");
			}
			if (counter == footerElementsList.length)
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
