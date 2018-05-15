package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonPlus;
    @FindBy (xpath = ".//tr[2]")
    private WebElement anyElementInList;

    public ServicePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/service");
    }

    public void clickOnButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public void clickOnAnyElementInList (){
        actionsWithOurElements.clickOnElement(anyElementInList);
    }
}