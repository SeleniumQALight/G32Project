package pages;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends parentPage{


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LogIn page was opened");

        }catch (Exception e){
            logger.error("Cannot open LogInPage");
            Assert.fail("Cannot open LogInPage");

        }
    }

    public void enterLogIn(String login){
        WebElement inputLogIn = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }
}
