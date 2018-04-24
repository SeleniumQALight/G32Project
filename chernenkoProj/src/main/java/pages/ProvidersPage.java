package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement buttonPlus;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver,"/dictionary/providers");
    }

    public void clickOnButtonPlus(){
        actionWithOurElements.clickOnElement(buttonPlus);
    }
}
