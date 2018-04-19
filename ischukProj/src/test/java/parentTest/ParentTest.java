package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webdriver;
    protected LoginPage loginPage;


    @Before
    public void setUp() {

        File fileChrome = new File("./src/drivers/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(webdriver);

    }

    @After
    public void tearDown() {
        webdriver.quit();
    }
}