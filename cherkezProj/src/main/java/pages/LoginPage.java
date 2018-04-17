package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }

    public void enterLogin(String login) {
        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        WebElement inputPassword = webDriver.findElement(By.id("password"));
        actionsWithOurElements.enterTextInToElement(inputPassword, password);

    }

    public void pressLoginButton() {
        WebElement loginButton = webDriver.findElement(By.tagName("button"));
        actionsWithOurElements.pressButton(loginButton);
    }
}
