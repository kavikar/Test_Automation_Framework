package com.kar.steps;

import com.kar.pages.PageBase;
import com.kar.pages.actions.TestActions;
import com.kar.pages.objects.TestObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import utilities.GlobalRepo;
import utilities.SelectWebDriver;

import static utilities.GlobalRepo.properties;

public class StepDefinition {

    SelectWebDriver selectWebDriver = new SelectWebDriver();
    TestActions testActions;
    TestObjects testObjects;
    Scenario scenario;
    public Logger logger = Logger.getLogger(StepDefinition.class);

    @Before
    public void startTest(Scenario scenario) {
        this.scenario = scenario;
        GlobalRepo.scenario = scenario;
        BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/configuration/log4j.properties");
        System.out.println("Started Testing");
        if (!scenario.getUri().getPath().toLowerCase().contains("api")) {
            selectWebDriver.setWebDriver(properties.getProperty("browser"));
            testActions = new TestActions(GlobalRepo.webDriver, GlobalRepo.scenario);
            testObjects = new TestObjects(GlobalRepo.webDriver);
        }
    }

    @After
    public void endTest() {
        if (!scenario.getUri().getPath().toLowerCase().contains("api")) {
            if (scenario.isFailed()) {
                System.out.println("Scenario Failed");
                testActions.takeScreenshot();
            }
            GlobalRepo.webDriver.quit();
        }
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
