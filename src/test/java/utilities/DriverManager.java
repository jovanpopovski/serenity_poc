package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public class DriverManager {
    private static WebDriver driver;
    private static String browser;
    static ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver getDriver() throws IOException {
        browser = configFileReader.getProperty("browser");
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalStateException("Invalid browser type. Please specify either 'chrome' or 'firefox'.");
            }
        }
        return driver;
    }
}
