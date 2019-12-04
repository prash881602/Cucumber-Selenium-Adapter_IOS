package org.cts.oneframework.cucumber.pageobjectmanager;

import org.cts.oneframework.cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class PageObjectManager{

	private IOSDriver<MobileElement> driver;
	private HomePage homePage;

	public PageObjectManager(IOSDriver<MobileElement> driver) {
		this.driver = (IOSDriver<MobileElement>) driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

}