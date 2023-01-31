package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverManager {
    private static WebDriver driver;
    private static String browser;
    static ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver getDriver() throws IOException {
        browser = configFileReader.getProperty("browser");
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalStateException("Invalid browser type. Please specify either 'chrome' or 'firefox'.");
            }
        }
        return driver;
    }
}
