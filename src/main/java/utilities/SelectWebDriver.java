package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;


public class SelectWebDriver {

    /**
     * This method will set the appropriate web driver
     *
     * @param browserName -> Browser to be launched
     */
    public void setWebDriver(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                GlobalRepo.webDriver = new ChromeDriver();
                GlobalRepo.webDriver.manage().window().maximize();
                GlobalRepo.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                GlobalRepo.webDriver = new EdgeDriver();
                GlobalRepo.webDriver.manage().window().maximize();
                GlobalRepo.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else if (browserName.equalsIgnoreCase("headless")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-extensions");
                WebDriverManager.chromedriver().capabilities(chromeOptions).setup();
                GlobalRepo.webDriver = new ChromeDriver();
                GlobalRepo.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else {
                System.out.println("No Driver Found with Browser Name : " + browserName);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
