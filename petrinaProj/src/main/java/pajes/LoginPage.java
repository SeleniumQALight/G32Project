package pajes;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }
    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can't open LoginPage");
            Assert.fail("Can not open LoginPage");
        }

    }
    @Step

    public void enterLogin(String login) {
        //   WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }
    @Step
    public void enterPass(String pass) {
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }
    @Step
    public void clickSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    @Step
    public void userLogin(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPass(pass);
        clickSubmitButton();
    }
}
