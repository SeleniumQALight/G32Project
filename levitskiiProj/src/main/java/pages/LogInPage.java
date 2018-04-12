package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends ParentPage{


    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can't open LogInPage");
            Assert.fail("Can't open LogInPage");
        }
    }
        public void enterLogin (String login){
            WebElement inputLogin = webDriver.findElement(By.name("_username"));
            actionsWithOurElements.enterTextIntoElement(inputLogin, login);
        }

}
