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

    @FindBy (tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage (WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage (){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
    }catch (Exception e){
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterLogin (String login){
       // WebElement inputLogin = webDriver.findElement(By.name("_username")); ne nyzen,poskolky est anotacia
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }

    public void enterPass (String pass) {
        //WebElement inputPass = webDriver.findElement(By.id("password"));  ne nyzen,poskolky est anotacia
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }

    public void clickSubmitButton () {
        //WebElement buttonSubmit = webDriver.findElement(By.tagName("button"));  ne nyzen,poskolky est anotacia
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public void userLogin(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPass(pass);
        clickSubmitButton();
    }
}
