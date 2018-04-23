package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealSidesPage extends ParentPage {

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public DealSidesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }
}
