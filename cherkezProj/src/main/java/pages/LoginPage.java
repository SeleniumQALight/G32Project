package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }

    public void enterLogin(String login) {
        //      WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextInToElement(inputPassword, password);

    }

    public void clickSubmitButton() {
        actionsWithOurElements.pressButton(buttonSubmit);
    }

    public void userLogIn(String login, String password) {
        openPage();
        enterLogin(login);
        enterPassword(password);
        clickSubmitButton();
    }
}
