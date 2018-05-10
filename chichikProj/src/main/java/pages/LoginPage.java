package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends parentPage{
    @FindBy(name = "_username")
    private WebElement inputLogIn;

    @FindBy(name = "_password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement clickSubmit;



    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LogIn page was opened");

        }catch (Exception e){
            logger.error("Cannot open LogInPage");
            Assert.fail("Cannot open LogInPage");

        }
    }

    @Step
    public void enterLogIn(String login){
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }

    @Step
    public void enterPass(String pass){
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);

    }

    @Step
    public void clickSubmitButton(){
        actionsWithOurElements.clickOnElement(clickSubmit);
    }

    @Step
    public void userLogIn(String login, String pass) {
        openPage();
        enterLogIn(login);
        enterPass(pass);
        clickSubmitButton();
    }
}
