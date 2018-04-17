package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends parentPage{


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("LogIn page was opened");

        }catch (Exception e){
            logger.error("Cannot open LogInPage");
            Assert.fail("Cannot open LogInPage");

        }
    }

    public void enterLogIn(String login){
        WebElement inputLogIn = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }

    public void enterPass(String pass){
        WebElement inputPass = webDriver.findElement(By.name("_password"));
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);

    }

    public void clickSubmitButton(){
        WebElement clickSubmit = webDriver.findElement(By.xpath(".//button[@type='submit']"));
        actionsWithOurElements.clickOnElement(clickSubmit);
    }
}
