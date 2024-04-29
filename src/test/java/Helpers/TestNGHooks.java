package Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestNGHooks {

    public static WebDriver driver;

    @BeforeSuite

    public void openBrowser()  {
        driver = BrowserFactory.getDriver();
        driver.get("https://robotsparebinindustries.com/");
    }

    @AfterSuite

    public void closeBrowser(){
        BrowserFactory.tearDown();
    }
}
