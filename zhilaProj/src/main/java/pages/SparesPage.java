package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {

    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement addButon;
    private EditSparesPage editSparesPage;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparesPage = new EditSparesPage(webDriver);
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

    public void deletingAllSpares(String nameOfNewSpare) {
        while (isNewSpareInList(nameOfNewSpare)) {
            clickOnSpare(nameOfNewSpare);
            editSparesPage.clickButtonDelete();
            logger.info("Spare with name " + nameOfNewSpare + " was deleted");
        }
    }
}
