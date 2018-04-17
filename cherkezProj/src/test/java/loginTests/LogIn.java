package loginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LogIn {

    WebDriver WebDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver = new ChromeDriver();
    }

    @Test
    public void validLogIn() {

        WebDriver.manage().window().maximize();
        WebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriver.get("http://v3.test.itpmgroup.com/login");
        WebDriver.findElement(By.name("_username")).sendKeys("Student");
        WebDriver.findElement(By.id("password")).sendKeys("909090");
        WebDriver.findElement(By.tagName("button")).click();
        Assert.assertTrue("Avatar is not present",
                isAvatarPresent()
        );
    }

    @After
    public void tearDown() {
        WebDriver.quit();
    }

    private boolean isAvatarPresent() {
        try {
            return WebDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

