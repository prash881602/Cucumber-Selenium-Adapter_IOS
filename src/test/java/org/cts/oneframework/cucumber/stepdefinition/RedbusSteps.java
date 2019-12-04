package org.cts.oneframework.cucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.utilities.DateUtils;
import org.cts.oneframework.utilities.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class RedbusSteps extends AbstractSteps {

	public RedbusSteps() {
		super();
	}

	@When("^Browser is launched and navigate to specified url$")
	public void browser_is_launched_and_navigate_to_specified_url() {
		startDriver();
		driver.get(ConfigProvider.getAsString("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Book a bus ticket$")
	public void book_a_bus_ticket() {
		getPageObjectManager().getHomePage().search().setSource(DefaultStepDefinition.getCellData("from")).setDestination(DefaultStepDefinition.getCellData("to")).selectOnwardDate(DateUtils.getCurrentDate("d-MMM yyyy")).selectReturnDate(DateUtils.getTomorrowDate("d-MMM yyyy")).searchBuses();
	}

	@Then("Book a bus ticket from {string} to {string}")
	public void book_a_bus_ticket_from_to(String from, String to) throws InterruptedException {
		try {
			Thread.sleep(5000);
			selectSource(from);
			selectDestination(to);
			searchBuses();
			stopDriver();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
		//getPageObjectManager().getHomePage().search().setSource(DefaultStepDefinition.getCellData("from")).setDestination(DefaultStepDefinition.getCellData("to")).selectOnwardDate(DateUtils.getCurrentDate("d-MMM yyyy")).selectReturnDate(DateUtils.getTomorrowDate("d-MMM yyyy")).searchBuses();
	public void selectSource(String from) {	
		try {
	driver.findElementById("fromIp").click();
		Thread.sleep(5000);
		driver.findElementById("suggestInput").sendKeys(from);
		Screenshots.addStepWithScreenshotInReport(driver, "Entered "+from+" as Source");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		//Select drpCountry = new Select(driver.findElementById("selectCity"));
		//drpCountry.selectByIndex(1);
		
		
		driver.findElementById("selectCity").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//ul//li[@data-locationtype='CITY'])[1]").click();
		Thread.sleep(5000);
		}catch(Exception e) {
		}
	}
		public void selectDestination(String to) {	
		try {
		driver.findElementById("toIp").click();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@placeholder='Enter Area , City Name']").sendKeys(to);
		
		
		//driver.findElementById("suggestInput").sendKeys("hyderabad");
		Screenshots.addStepWithScreenshotInReport(driver, "Entered  "+to+" as Destination");
		Thread.sleep(5000);
		driver.findElementById("selectCity").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//ul//li[@data-locationtype='CITY'])[1]").click();
		Thread.sleep(5000);
		}
		catch(Exception e) {
			//driver.findElementById("toIp").click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@placeholder='Enter Area , City Name']").sendKeys(to);
		}
		}
		public void searchBuses() {
		//driver.findElementById("suggestInput").sendKeys("Madiwala, Bengaluru");
			try {
				Thread.sleep(5000);
		driver.findElementById("search_button").click();
		
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshots.addStepWithScreenshotInReport(driver, "Clicked on Search Buses and Results are displayed");
		//stopDriver();
	}

}
