package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import testBase.BaseDriverClass;


public class AllureTestListener implements ITestListener {
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Image attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain", fileExtension = ".txt")
	public static String saveTextLog(String message) {
		return message;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		//iTestContext.setAttribute("WebDriver", BaseDriverClass.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Method: " + getTestMethodName(iTestResult) + " has failed");
		@SuppressWarnings("unused")
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseDriverClass.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for failed test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}

}
