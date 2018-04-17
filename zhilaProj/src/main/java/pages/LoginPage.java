package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name ="_username")
    private WebElement inputLogin;
    @FindBy(id= "password")
    private WebElement inputPassword;
    @FindBy (tagName ="button")
    private WebElement clickSubmitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e)
        {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterLogin(String login){
        actionWithOurElements.enterTextInToElement(inputLogin,login);
    }

    public void enterPassword(String password){
        actionWithOurElements.enterTextInToElement(inputPassword,password);
    }

    public void clickSubmitButton(){
        actionWithOurElements.clickOnElement(clickSubmitButton);
    }

    public void userLogin(String login, String password) {
        openPage();
        enterLogin(login);
        enterPassword(password);
        clickSubmitButton();
    }
}
