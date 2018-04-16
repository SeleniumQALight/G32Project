package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class LoginPage extends ParentPage{


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }
    public void enterLogin(String login){
        WebElement inputLogin = webDriver.findElement(name("_username"));
        actionWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String password){
        WebElement inputPassword = webDriver.findElement(name("_password"));
        actionWithOurElements.enterTextInToElement(inputPassword, password);
    }
    public  void clickButton(){
        WebElement clickElement = webDriver.findElement(By.tagName("button"));
        actionWithOurElements.clickOnElement(clickElement);
    }
}
