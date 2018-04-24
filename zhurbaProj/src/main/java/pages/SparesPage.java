package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }

    public boolean isNewSpareInList(String nameOfNewSpare) {
        return actionsWithOurElements.isElementInLast(".//*[test()='" + nameOfNewSpare + "'");
    }
}
