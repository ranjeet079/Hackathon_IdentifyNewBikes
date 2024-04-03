package stepDefinitions;
//import java.io.IOException;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.LogManager;

//import org.testng.annotations.Test;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.Upcomingbikes;
//import factory.BaseClass;
import io.cucumber.java.en.Then;

public class TC001_Upcomingbikes extends BaseClass {
	
	
	Logger logger=LogManager.getLogger(TC001_Upcomingbikes.class);
	@Given("I open the website Zigwheels.com")
	public void i_open_the_website_Zigwheels_com() throws InterruptedException {
		// Write code here to open the website
		logger.info("**** Starting TC_001_UpcomingBike ****");
		logger.info("clicking on  New Bikes ");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		// click on new bikes
		Thread.sleep(2000);
		upcomingBike.HoverNewBikes();
	}

//	@Test(groups= {"smoke","regression","master"})
//	public void HoverNewBikes() throws InterruptedException, IOException {
//		logger.info("**** Starting TC_001_UpcomingBike ****");
//			logger.info("clicking on  New Bikes ");
//			Upcomingbikes upcomingBike = new Upcomingbikes(driver);
//			// click on new bikes
//			upcomingBike.HoverNewBikes();
//		}

	@When("I select upcoming bikes")
	public void i_select_upcoming_bikes() throws InterruptedException, IOException {
		// Write code here to select upcoming bikes
		logger.info("Selecting Upcoming Bikes");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		Thread.sleep(2000);
		upcomingBike.selectUpcomingBikes();

	}

	@When("clicking on upcoming bikes")
	public void clicking_on_upcoming_bikes() throws InterruptedException {
		// Write code here to click on upcoming bikes
		logger.info("clicking on Upcoming Bikes");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		Thread.sleep(2000);
		// Click on Brand
		upcomingBike.clickBrand();
		
		Thread.sleep(2000);
		// View more bikes
		upcomingBike.clickViewMoreButton();
	}

	@Then("Display bike details")
	public void display_bike_details() throws IOException, InterruptedException {
		// Write code here to display bike details
		logger.info("Displaying bikes details");
		Upcomingbikes upcomingBike = new Upcomingbikes(driver);
		
		Thread.sleep(2000);
		upcomingBike.bikeDetails();
		logger.info("**** Finished TC_001_UpcomingBike ****");

	}
}
