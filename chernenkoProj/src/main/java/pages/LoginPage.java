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

    @FindBy(xpath = ".//button" )
    private WebElement buttonSubmit;


    public LoginPage(WebDriver webDriver) {
        super(webDriver,"/login");
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
        actionWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPassword(String password){
        actionWithOurElements.enterTextIntoElement(inputPass, password);
    }

    public void clickSubmitButton(){
        actionWithOurElements.clickOnElement(buttonSubmit);
    }


    public void userLogin(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPassword(pass);
        clickSubmitButton();
    }
}
