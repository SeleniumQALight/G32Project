package parentTest;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;
    protected EditSparesPage editSparesPage;
    protected DealSidesPage dealSidesPage;
    protected EditDealSidesPage editDealSidesPage;
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
        sparesPage = new SparesPage(webDriver);
        editSparesPage = new EditSparesPage(webDriver);
        dealSidesPage = new DealSidesPage(webDriver);
        editDealSidesPage = new EditDealSidesPage(webDriver);
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
