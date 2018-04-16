package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  extends ParentPage {


    public LoginPage (WebDriver webDriver) {
        super (webDriver);
    }


    public void openPage()    {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was open");

        } catch (Exception e) {
logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }
    public void enerLogin (String login) {
        WebElement inptLogin = webDriver.findElement(By.name(" username"));
        actionsWithOurElements.enterTextIntoElement(inptLogin, login);
    }
}
