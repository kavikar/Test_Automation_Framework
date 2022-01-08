package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * This method helps to read properties from config files
     *
     * @return properties Object
     */
    public Properties readProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("/configuration/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
