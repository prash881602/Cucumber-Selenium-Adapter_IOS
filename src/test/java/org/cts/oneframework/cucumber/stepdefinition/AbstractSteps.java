package org.cts.oneframework.cucumber.stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.cts.oneframewok.seleniumadapter.drivers.DriverManager;
import org.cts.oneframewok.seleniumadapter.drivers.DriverManagerFactory;
//import org.cts.oneframework.capabilities.AndroidCapabilities;
import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.cucumber.pageobjectmanager.PageObjectManager;
import org.cts.oneframework.utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public abstract class AbstractSteps {

	private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
	protected static IOSDriver<MobileElement> driver;
	private static ThreadLocal<PageObjectManager> pageObjectManager = new ThreadLocal<>();

	public void startDriver() {
		String browserName = ConfigProvider.getAsString("browser");
		if (driverManager.get() == null)
			driverManager.set(DriverManagerFactory.getManager(browserName));
		//driver.set(driverManager.get().getDriver());
		//driver.get().manage().timeouts().implicitlyWait(ConfigProvider.getAsInt("ImplicitWait"), TimeUnit.SECONDS);
		if (browserName.equalsIgnoreCase("chrome"))
			//driver.get().manage().window().maximize();
			driver = launchApp();
		driver.get(ConfigProvider.getAsString("url"));
		Screenshots.addStepWithScreenshotInReport(driver, "App launched.");
	}

	public void stopDriver() {
		//if (driverManager.get() != null)
		//	driverManager.get().stopService();
		//else {
		//	throw new RuntimeException("DriverManager is null");
		//}
		driver.quit();
	}

	public IOSDriver<MobileElement> getDriver() {
		IOSDriver<MobileElement> driver = null;
		return driver;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager.get();

	}
	public IOSDriver<MobileElement> launchApp() {
		DesiredCapabilities capabilities = IOSCapabilities.set();
		URL url = null;
		try {
			url = new URL(ConfigProvider.getAsString("appiumServerURL"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new IOSDriver<MobileElement>(url, capabilities);
		Screenshots.addStepWithScreenshotInReport(driver, "App launched.");
		return driver;
	}
}
