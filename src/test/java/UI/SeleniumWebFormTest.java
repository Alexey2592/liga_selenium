package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumWebFormTest {

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testWebForm() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Мищенко Алексей Павлович");

        WebElement passwordInput = driver.findElement(By.name("my-password"));
        passwordInput.sendKeys("Password");

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("ПАО Сбербанк");

        Assert.assertEquals(textInput.getAttribute("value"), "Мищенко Алексей Павлович");
        Assert.assertEquals(passwordInput.getAttribute("value"), "Password");
        Assert.assertEquals(textarea.getAttribute("value"), "ПАО Сбербанк");

        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");

        WebElement datalist = driver.findElement(By.name("my-datalist"));
        datalist.sendKeys("Seattle");

        WebElement checkbox1 = driver.findElement(By.id("my-check-1"));
        WebElement checkbox2 = driver.findElement(By.id("my-check-2"));

        if (!checkbox1.isSelected()) checkbox1.click();
        if (!checkbox2.isSelected()) checkbox2.click();

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());

        WebElement radioButton = driver.findElement(By.id("my-radio-2"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());

        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("09/23/2024");

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.sendKeys("#00FF00");

        WebElement range = driver.findElement(By.name("my-range"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '5';", range);

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "Received!");
    }

    @Test
    public void checkPageTitle() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String pageTitle = driver.getTitle();
        System.out.println("Title: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Web form"));
    }
}
