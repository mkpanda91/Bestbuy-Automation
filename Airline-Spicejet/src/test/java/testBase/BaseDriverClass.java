package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverClass {

	protected static WebDriver driver;
	ChromeOptions chromeOptions;
	FirefoxOptions firefoxOptions;
	EdgeOptions edgeOptions;
	protected Properties p;
	protected String expectedUrl = "https://www.spicejet.com";
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	@BeforeMethod (alwaysRun = true)
	@Parameters({ "browser" })
	public void setupBrowser(String br) throws IOException {

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
			chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-geolocation");
			chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
			// WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			break;

		case "edge":
			edgeOptions = new EdgeOptions();
			edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			edgeOptions.addArguments("--disable-notifications");
			edgeOptions.addArguments("--guest");
			edgeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = WebDriverManager.edgedriver().capabilities(edgeOptions).create();
			// WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
			break;

		case "firefox":
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			firefoxOptions.addArguments("--disable-notifications");
			firefoxOptions.addPreference("dom.push.enabled", false);
			firefoxOptions.addPreference("dom.webnotifications.enabled", false);
			firefoxOptions.addPreference("geo.enabled", false);
			driver = WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create();
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			break;

		case "headless chrome":
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless=new", "--start-maximized", "--disable-gpu",
					"--window-size=1920,1080");
			driver = new ChromeDriver(chromeOptions);
			break;

		case "headless firefox":
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless=new");
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "headless edge":
			edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless=new");
			driver = new EdgeDriver(edgeOptions);
			break;

		default:
			System.out.println("No matching browser for execution");
			return;
		}
		// generic steps for browser before test
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		tdriver.set(driver);
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
