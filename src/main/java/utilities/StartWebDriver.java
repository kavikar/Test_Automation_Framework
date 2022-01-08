package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class StartWebDriver {

    public WebDriver webDriver;

    /**
     * This method will set the appropriate web driver
     *
     * @param browserName -> Browser to be launched
     */
    public WebDriver setWebDriver(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            } else {
                System.out.println("No Driver Found with Name : " + browserName);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return webDriver;
    }

}
