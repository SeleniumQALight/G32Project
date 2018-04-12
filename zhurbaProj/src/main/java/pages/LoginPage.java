package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened successfully.");
        } catch (Exception e) {
            logger.error("Login Page was NOT opened.");
            Assert.fail("Login Page was NOT opened.");
        }
    }
}
