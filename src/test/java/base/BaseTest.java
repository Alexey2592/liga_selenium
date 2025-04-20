package base;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public  void setupClass(){
        driver = Browser.createDriver();

    }
    @AfterClass
    public void tearDownClass(){
        if (driver != null) {
            driver.quit();
        }
    }
}
