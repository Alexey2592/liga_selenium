package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class textBoxTEst {

    public WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTextBox(){
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("KEK");

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("kek@mail.ru");

        WebElement correntAdressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        correntAdressTextArea.sendKeys("Нижний Новгород");


        WebElement permanentAdressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdressTextArea.sendKeys("Нижний Новгород");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",button);
        button.click();

        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement correntAdressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAdressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String correntAdress = correntAdressOutput.getText();
        String permanentAdress = permanentAdressOutput.getText();

        System.out.println("name: "+ name + ", email : " + email
                        + " , corrent adress : " + correntAdress + " , permanent Adress : " + permanentAdress);

 //       Assert.assertTrue(name.contains("KK"),"Message");
        Assert.assertEquals(email,"Email:kek@mail.ru");


//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    public void checkTitleTextBox(){
        String pageTitle = driver.getTitle();
        System.out.println("Title : " + pageTitle);
    }

}
