package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{
    @FindBy(xpath=".//*[@data-original-title='Add']")
    private WebElement buttonPlus;
    private EditSparesPage editSparesPage;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparesPage = new EditSparesPage(webDriver);
    }
    @Step
    public void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }
    @Step
    public boolean isSpareInList(String nameOfNewSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare +"']");
    }
    @Step
    public void clickOnSpare(String nameOfNewSpare) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfNewSpare +"']");
    }
    @Step
    public void deletingAllSparesWithName (String nameOfNewSpare) {
        while (isSpareInList(nameOfNewSpare)){
            clickOnSpare(nameOfNewSpare);
            editSparesPage.clickButtonDelete();
            logger.info("Spare with name " + nameOfNewSpare + " was deleted");
        }
    }
}

