package parentTest;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        File fileCh = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileCh.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkAC(String message, boolean expected, boolean actual){
        if(!(actual==expected)) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, actual, expected);
    }
}
