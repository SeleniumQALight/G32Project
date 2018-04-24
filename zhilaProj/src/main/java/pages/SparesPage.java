package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {

    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement addButon;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickAddButton(){
        actionWithOurElements.clickOnElement(addButon);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }

    public boolean isNewSpareInList(String nameOfNewSpare) {
        return actionWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare + "']");
    }

    public void clickOnSpare(String nameOfNewSpare) {
        actionWithOurElements.clickOnElement(".//*[text()='" + nameOfNewSpare + "']");
    }
}
