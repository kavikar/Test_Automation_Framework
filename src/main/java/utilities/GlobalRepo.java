package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class GlobalRepo {
    public static WebDriver webDriver;
    public static Scenario scenario;
    public static ConfigReader configReader = new ConfigReader();
    public static Properties properties = configReader.readProperties();

}
