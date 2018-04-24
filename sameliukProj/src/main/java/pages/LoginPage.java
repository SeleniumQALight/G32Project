package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy (name = "_username")
    private WebElement inputLogin;
    @FindBy (id = "password")
    private WebElement inputPass;
    @FindBy (tagName = "button")
    private WebElement buttonSubmit;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }


    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was open");

        } catch (Exception e) {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enerLogin(String login) {
      //  WebElement inputLogin = webDriver.findElement(By.name("_username"));
        actionsWithOurElements.enterTextIntoElement(inputLogin, login); //inputLogin объявлен через аннотацию @FindBy
    }

    public void enterPass(String pass) {
       // WebElement inputPassword = webDriver.findElement(By.name("_password"));
        actionsWithOurElements.enterTextIntoElement(inputPass, pass); //inputPass объявлен через аннотацию @FindBy
    }

    public void clickSubmitButton() {
       // WebElement buttonSubmit = webDriver.findElement(By.xpath(".//button[@type='submit'] "));
        actionsWithOurElements.clickOnElement (buttonSubmit); //buttonSubmit объявлен через аннотацию @FindBy
    }
    public void userLogin(String login, String password) {
        openPage();
        enerLogin(login);
        enterPass(password);
        clickSubmitButton();
    }
}
