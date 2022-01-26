package com.kar.pages;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utilities.GlobalRepo.properties;
import java.io.File;
import java.time.Duration;
import org.apache.log4j.Logger;

public class PageBase {
    protected WebDriver driver;
    protected Scenario scenario;
    private static final Logger logger = Logger.getLogger(PageBase.class);
    public static Duration twoSeconds = Duration.ofSeconds(2);
    public static Duration fiveSeconds = Duration.ofSeconds(5);
    public static Duration tenSeconds = Duration.ofSeconds(10);
    public static Duration twentySeconds = Duration.ofSeconds(20);
    public static Duration thirtySeconds = Duration.ofSeconds(30);

    public void takeScreenshot() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        } catch (Exception e) {
            System.out.println("Failed to take screenshot");
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement webElement, String elementName, Duration duration) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            System.out.println(elementName + " is displayed");
            return true;
        } catch (Exception e) {
            System.out.println(elementName + " is not displayed");
            System.out.println("Exception : " + e.getMessage());
            return false;
        }
    }

    public boolean clickOnElement(WebElement webElement, String elementName) {
        try {
            webElement.click();
            System.out.println("Clicked/Selected : " + elementName);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click/select : " + elementName);
            System.out.println("Exception : " + e.getMessage());
            return false;
        }
    }
}
