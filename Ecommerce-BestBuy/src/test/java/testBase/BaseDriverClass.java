package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CountrySelectionPage;

public class BaseDriverClass {

	protected static WebDriver driver;
	CountrySelectionPage coPage;
	protected Properties p;
	protected String expectedUrl = "https://www.bestbuy.com/";
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	FirefoxOptions foptions;
	EdgeOptions eoptions;
	ChromeOptions coptions;

	@BeforeClass
	@Parameters({ "browser" })
	public WebDriver setupBrowser(String br) {

		// loading properties file
		FileReader file;
		try {
			file = new FileReader("./src/test/resources/config.properties");
			p = new Properties();
			p.load(file);
		} catch (FileNotFoundException e) {
			System.out.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e.getMessage());
		}

		// launching browser based on parameter
		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "headless chrome":
			coptions = new ChromeOptions();
			coptions.addArguments("--headless=new", "--start-maximized", "--disable-gpu", "--window-size=1920,1080");
			driver = new ChromeDriver(coptions);
			break;

		case "headless firefox":
			foptions = new FirefoxOptions();
			foptions.addArguments("--headless=new");
			driver = new FirefoxDriver(foptions);
			break;

		case "headless edge":
			eoptions = new EdgeOptions();
			eoptions.addArguments("--headless=new");
			driver = new EdgeDriver(eoptions);
			break;

		default:
			System.out.println("No matching browser for execution");
			// return;
		}
		// generic steps for browser before test
		tdriver.set(driver);
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}

	// To setup country as USA or Canada before respective tests
	public void setupCountry(String setCont) {
		coPage = new CountrySelectionPage(driver);
		switch (setCont.toUpperCase()) {
		case "USA":
			coPage.chooseCountryAsUS();
			break;

		case "CANADA":
			coPage.chooseCountryAsCanada();
			break;

		default:
			System.out.println("Improper country is selected as Location");
		}
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
