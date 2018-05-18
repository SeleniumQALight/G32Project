package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage{
    @FindBy(name ="_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy (tagName = "button")
    private WebElement buttonSubmit;


    public LogInPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }
    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can't open LogInPage");
            Assert.fail("Can't open LogInPage");
        }
    }
    @Step
        public void enterLogin (String login){
  //          WebElement inputLogin = webDriver.findElement(By.name("_username"));
            actionsWithOurElements.enterTextIntoElement(inputLogin, login);
        }
    @Step
        public void enterPass(String password){
  //      WebElement inputPassword = webDriver.findElement(By.id("password"));
            actionsWithOurElements.enterTextIntoElement(inputPassword, password);
        }
    @Step
        public void clickSubmitButton(){
   //     WebElement buttonSubmit = webDriver.findElement(By.tagName("button"));
        actionsWithOurElements.clickOnElement(buttonSubmit);
        }
        @Step
    public void userLogIn(String logIn, String pass) {
        openPage();
        enterLogin(logIn);
        enterPass(pass);
        clickSubmitButton();
    }
}

