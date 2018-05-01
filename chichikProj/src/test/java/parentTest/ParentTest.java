package parentTest;

import loginTests.LogIn;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparePage;
    protected EditSparesPage editSparesPage;
    protected ProvidersPage providersPage;
    protected EditProviders editProviders;
    Logger logger = Logger.getLogger(getClass());

    private String browser = System.getProperty("browser");

    @Before
    public void setUp() {
        if ("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        }else if ("ie".equals(browser)){
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        }else if ("fireFox".equals(browser)){
            logger.info("FireFox will be started");
            File fileFF = new File(".././drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0); // Empty start page
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver(profile);
            logger.info(" FireFox is started");

        }
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparesPage(webDriver);
        sparePage = new SparesPage(webDriver);
        editSparesPage = new EditSparesPage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        editProviders = new EditProviders(webDriver);
    }

    @After
    public void tearDown() {

        webDriver.quit();
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected) {
        if (!(actual == expected)) {
            logger.error("Acceptance fails: " + message);
        }
        Assert.assertEquals(message, expected, actual);

    }
}
