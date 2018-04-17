package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webdriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {

        File fileChrome = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(webdriver);
        homePage = new HomePage(webdriver);

    }

    @After
    public void tearDown() {
        webdriver.quit();
    }

    protected void  checkAC(String message, boolean actual, boolean expected){
        if(!(actual == expected)) {
            logger.error("AC failed:" + message);
        }
        Assert.assertEquals(message, expected, actual);
    }

}
