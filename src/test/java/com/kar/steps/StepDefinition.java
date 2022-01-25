package com.kar.steps;

import com.kar.pages.actions.TestActions;
import com.kar.pages.objects.TestObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.GlobalRepo;
import utilities.SelectWebDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StepDefinition {

    SelectWebDriver selectWebDriver = new SelectWebDriver();
    ConfigReader configReader = new ConfigReader();
    Properties properties = configReader.readProperties();
    TestActions testActions;
    TestObjects testObjects;
    Scenario scenario;

    @Before
    public void startTest (Scenario scenario) {
        this.scenario = scenario;
        System.out.println("Started Testing");
        selectWebDriver.setWebDriver(properties.getProperty("browser"));
        GlobalRepo.scenario = scenario;
        testActions = new TestActions(GlobalRepo.webDriver,GlobalRepo.scenario);
        testObjects = new TestObjects(GlobalRepo.webDriver);
    }

    @After
    public void endTest () {
        if (scenario.isFailed()) {
            System.out.println("Scenario Failed");
            testActions.takeScreenshot();
        }
        GlobalRepo.webDriver.quit();
    }

    @Given("User launches website url")
    public void userLaunchesWebsiteUrl() {
        testActions.launchSiteURL();
    }

    @Then("User validates that logo is visible")
    public void userValidatesThatLogoIsVisible() {
        Assert.assertTrue(testActions.checkIfLogoIsVisible());
    }
}
