package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SparesPage extends parentPage{

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement addButton;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickAddButton(){
        actionsWithOurElements.clickOnElement(addButton);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }

    public boolean isSpareInList(String nameOfNewSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare + "']");
    }
}
