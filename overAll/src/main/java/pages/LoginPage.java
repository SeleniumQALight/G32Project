package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver,"/login");
    }

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterLogin(String login){
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPass(String pass){
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }

    public void clickSubmitButton(){
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public void userLogIn(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPass(pass);
        clickSubmitButton();
    }
}