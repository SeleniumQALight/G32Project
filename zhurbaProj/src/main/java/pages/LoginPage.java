package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super (webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened SUCCESSFULLY.");
        } catch (Exception e) {
            logger.error("Login Page was NOT opened.");
            Assert.fail("Login Page was NOT opened.");
        }
    }

    public void enterLogin(String login){
        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String password){
        WebElement inputPassword = webDriver.findElement(By.id("password"));
        actionsWithOurElements.enterTextInToElement(inputPassword, password);
    }

    public void clickOntoBxod(){
        WebElement findTheButton = webDriver.findElement(By.tagName("button"));
        actionsWithOurElements.clickOntoTheButton(findTheButton);
    }
}
