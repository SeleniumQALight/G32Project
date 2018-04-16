package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;

import java.awt.*;

public class LoginPage extends ParentPage {


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterLogin (String login){
        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextIntoElement(inputLogin,login);
    }

    public void enterPassword (String password) {
        WebElement inputPassword = webDriver.findElement(By.id("password"));
        actionsWithOurElements.enterTextIntoElement(inputPassword,password);
    }

    public void clickButton () {
        WebElement clickButtonVhod = webDriver.findElement(By.tagName("Button"));
        actionsWithOurElements.clickOnElement(clickButtonVhod);
    }
}

