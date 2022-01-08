import org.junit.After;
import org.junit.Before;
import utilities.ConfigReader;
import utilities.StartWebDriver;

import java.util.Properties;

public class LaunchTest {

    private final StartWebDriver startWebDriver;
    ConfigReader configReader = new ConfigReader();
    Properties properties = configReader.readProperties();

    public LaunchTest(StartWebDriver startWebDriver) {
        this.startWebDriver = startWebDriver;
    }

    @Before
    public void startTest () {
        startWebDriver.setWebDriver(properties.getProperty("browser"));
    }

    @After
    public void endTest () {

    }
}
