package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver("mozila");
        }
        return driver;
    }

    public static WebDriver driver;

    public static WebDriver createDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("mozila")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browserName entered " + browserName);
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
