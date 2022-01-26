package com.kar.pages.actions;

import com.kar.pages.objects.TestObjects;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import static utilities.GlobalRepo.properties;

public class TestActions extends TestObjects {

    public TestActions(WebDriver webDriver, Scenario scenario) {
        super(webDriver);
        this.driver = webDriver;
        this.scenario = scenario;
    }

    public void launchSiteURL() {
        try {
            driver.get(properties.getProperty("websiteURL"));
            System.out.println("Website is launched successfully");
        } catch (Exception e) {
            System.out.println("Failed to launch the website");
            System.out.println(e.getMessage());
        }
    }

    public boolean checkIfLogoIsVisible() {
        return isElementDisplayed(siteLogo, "Website Logo", fiveSeconds);
    }
}
