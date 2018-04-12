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
    WebDriver webdriver;
    @Before
            public void setUp() {

    File fileChrome = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
     webdriver = new ChromeDriver();
    }
    @Test
    public void validLogin(){

        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        webdriver.get("http://v3.test.itpmgroup.com");
        webdriver.findElement(By.name("_username")).sendKeys("Student");
        webdriver.findElement(By.id("password")).sendKeys("909090");
        webdriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present",
                isAvatarPresent()

            );



    }
    @After
    public void tearDown() {
        webdriver.quit();
    }

    private boolean isAvatarPresent(){
        try {
            return webdriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();
        }catch (Exception e) {
          return  false;
        }

    }

}
