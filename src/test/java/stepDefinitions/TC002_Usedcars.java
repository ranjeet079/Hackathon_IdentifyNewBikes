package stepDefinitions;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.Usedcars;
import factory.BaseClass;

public class TC002_Usedcars extends BaseClass{
    private Usedcars usedCar;
    Logger logger=LogManager.getLogger(TC002_Usedcars.class);

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        logger.info("**** Starting TC_002_UsedCar ****");
        try {
            logger.info("Navigating to the homepage");
            usedCar = new Usedcars(driver);
        } catch (Exception e) {
            logger.error("Failed to navigate to the homepage!!!");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @When("I hover over and select used cars")
    public void i_hover_over_and_select_used_cars() {
        try {
            logger.info("Hovering over and selecting used cars");
            usedCar.usedCarsMenu();
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.error("Failed to hover over and select used cars!!!");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @When("I select Chennai used cars")
    public void i_select_Chennai_used_cars() throws InterruptedException {
        try {
        	Thread.sleep(2000);
            logger.info("Selecting Chennai used cars");
            
            usedCar.selectChennaiUsedCars();
        } catch (IOException e) {
            logger.error("Failed to select Chennai used cars!!!");
            e.printStackTrace();
            Assert.fail();
        }
        
    }

    @Then("The popular models should be displayed")
    public void the_popular_models_should_be_displayed() throws InterruptedException {
    	Thread.sleep(2000);
        try {
            logger.info("Checking that the popular models are displayed");
            usedCar.extractPopularModels();
        } catch (Exception e) {
            logger.error("Failed to display the popular models!!!");
            e.printStackTrace();
            Assert.fail();
        }
        logger.info("**** Finished TC_002_UsedCar ****");
    }
}

